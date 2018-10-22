package com.model;

import com.app.Word;
import com.app.topic;
import com.app.wordTopic;
import com.module.formMain;
import com.sun.javafx.font.FontConstants;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author phixuanhoan
 */
public class myConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public String tableName = "tbl_edict";
    private String DB_host  = "jdbc:mysql://localhost:3306/";
    private String DB_user  = "root";
    private String DB_pass  = "";
    private String DB_name  = "edict";

    /**
     * Create a connect to database
     */
    public myConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_host + DB_name + "?useUnicode=true&characterEncoding=utf-8", DB_user, DB_pass);
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu ! vui lòng kết nối tới cơ sở dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public String replateAll(String s) {
        String arr[] = s.split("'");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                result += arr[i] + "\\'";
            } else {
                result += arr[i];
            }
        }
        return result;
    }
    /**
     * Get all data from database
     * @param start
     * @param num
     */
    public void getData(int start, int num) {
        try {
            String query = "SELECT * FROM `" + tableName + "` LIMIT " + num + " OFFSET " + (start - 1) + "";
            rs = st.executeQuery(query);
            while (rs.next()) {
                String word_Target = rs.getString("word").trim();
                String word_Explain = rs.getString("detail").trim();
                
                Word word = new Word(word_Target, word_Explain);
                formMain.dictionaryManagement.listWord.add(word);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Count all word in database
     * @return 
     */
    public int countWordInDatabase() {
        int totalWord = 0;
        try {
            String query = "SELECT COUNT(`word`) AS `total` FROM `" + tableName + "`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                totalWord = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalWord;
    }

    /**
     * Get the word LIKE @key (1-22)
     * @param key
     * @param typeSearch
     */
    public void seachKeyWord(String key, boolean typeSearch) {
        key = replateAll(key);
        try {
            String query;
            if (typeSearch == true) {
                query = "SELECT * FROM `" + tableName + "` WHERE `word` LIKE '" + key.trim() + "%' ORDER BY `word` LIMIT 23";
            } else {
                query = "SELECT * FROM `" + tableName + "` WHERE `word` ='" + key + "'";
            }
            rs = st.executeQuery(query);
            while (rs.next()) {
                String word_Target = rs.getString("word").trim();
                String word_Explain = rs.getString("detail").trim();
                Word word = new Word(word_Target, word_Explain);
                formMain.dictionaryManagement.listWord.add(word);

            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Insert data to database
     * @param target
     * @param explain
     */
    public void insertData(String target, String explain) {
        target = replateAll(target);
        explain = replateAll(explain);
        try {
            String query = "INSERT INTO `" + tableName + "`(`word`, `detail`) "
                    + "VALUES ('" + target + "', '" + explain + "')";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Update data by id
     * @param word
     * @param target
     * @param explain
     */
    public void updateData(String word, String target, String explain) {
        word = replateAll(word);
        target = replateAll(target);
        explain = replateAll(explain);
        explain = explain.replaceAll(word, target);
        try {
            String query = "UPDATE `" + tableName + "` SET `word` = '" + target 
                    + "', `detail` = '" + explain + "' WHERE `word` = '" + word + "'";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Delete data by "spelling"
     * @param target
     */
    public void deleteData(String target) {
        target = replateAll(target);
        try {
            String query = "DELETE FROM `" + tableName + "` WHERE `word` = '" + target + "'";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get all topic form database
     */
    public void getAllTopic() {
        try {
            String query = "SELECT * FROM `topic`";
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String topicName = rs.getString("name");
                topicName = topicName.trim();
                topic tp = new topic(id, topicName);
                topic.listTopic.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get info a topic by "topic_id"
     * @param topic_id
     */
    public void getWordByTopicID(int topic_id) {
        try {
            String query = "SELECT * FROM `newWord` WHERE `topic_id` = '" + topic_id + "'";
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String spelling = rs.getString("spelling").trim();
                String meaning = rs.getString("meaning").trim();
                String transcription = rs.getString("transcription").trim();
                String example = rs.getString("example").trim();
                String meaningExample = rs.getString("meaningExample").trim();
                String define = rs.getString("define").trim();
                String same;
                try {
                    same = rs.getString("same").trim();
                } catch (SQLException e) {
                    same = "";
                }
                String type = rs.getString("type").trim();
                int topic_ID = rs.getInt("topic_id");
                wordTopic word = new wordTopic(id, spelling, meaning, transcription, example,
                        meaningExample, define, same, type, topic_ID);
                topic.listWordTopic.add(word);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get info a user return @Arraylist
     * @param username
     * @return 
     */
    public ArrayList getInfoUser(String username) {
        ArrayList infoUser = new ArrayList<>();
        username = replateAll(username);
        try {
            String query = "SELECT `id`, `username`, `password`, `groupName`, "
                    + "`fullname` FROM `user` WHERE `username` = '" + username + "'";
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");
                String groupID = rs.getString("groupName");
                String fullname = rs.getString("fullname");
                infoUser.add(id);
                infoUser.add(usernameDB);
                infoUser.add(passwordDB);
                infoUser.add(groupID);
                infoUser.add(fullname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infoUser;
    }
    
    /**
     * Insert a User to database
     * @param username
     * @param password
     * @param fullname
     * @param email
     */
    public void insertUser(String username, String password, String fullname, String email) {
        username = replateAll(username);
        password = replateAll(password);
        fullname = replateAll(fullname);
        email = replateAll(email);
        
        try {
            String query = "INSERT INTO `user` (`username`,`password`, `email`, `fullname`, `groupName`) VALUES "
                        + "('" + username + "','" + password + "', '" + email + "', '" + fullname + "', 'member')";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Get info a word by @spelling
     * @param spWord
     * @return 
     */
    public ArrayList getInfoWordBySpelling(String spWord) {
        ArrayList<String> list = new ArrayList<>();
        spWord = replateAll(spWord);
        try {
            String query = "SELECT * FROM `" + tableName + "` WHERE `word` = '" + spWord + "'";
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idx");
                String idx = String.valueOf(id);
                String target = rs.getString("word").trim();
                String word_Explain = rs.getString("detail").trim();
                word_Explain = word_Explain.replaceAll("<br />", "\n    ").replaceAll("<[^>]*>", "")
                                .replaceAll("&amp", "").replaceAll("&lt;", "").replaceAll("&gt;", "");
                list.add(idx);
                list.add(target);
                list.add(word_Explain);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
