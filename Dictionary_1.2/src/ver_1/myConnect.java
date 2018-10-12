/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ver_1;

import com.sun.javafx.font.FontConstants;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phixuanhoan
 */
public class myConnect {
   private Connection con;
   private Statement st;
   private ResultSet rs;
   public String tableName = "word";
   private String DB_host = "jdbc:mysql://localhost:3306/";
   private String DB_user = "root";
   private String DB_pass = "";
   private String DB_name = "dictionary";
   public myConnect(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(DB_host+DB_name,DB_user,DB_pass);
           st = con.createStatement();
       } catch (Exception ex) {
           Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   /**
   * query và lấy dữ liệu từ database 
   */
   public void getData(){
        try {
           String query = "SELECT * FROM " + tableName;
           rs = st.executeQuery(query);
            while (rs.next()) {
                int id  = rs.getInt("id");
                String spelling = rs.getString("spelling").trim();
                String meaning = rs.getString("meaning").trim();
                String transcription = rs.getString("transcription").trim();
                String 	example = rs.getString("example").trim();
                String meaningExample = rs.getString("meaningExample").trim();
                
                newWord word = new newWord(id,spelling, meaning, transcription, example, meaningExample);
                dictionary.listWord.add(word);
                
            }
       } catch (Exception ex) {
           Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   /**
   * Thêm  1 từ vào database
   */
   public void insertData(int id,String spelling, String meaning, String transcription, String example, String meaningExample){
        try {
           String query = "INSERT INTO `"+ tableName +"`(`id`,`spelling`, `meaning`, `transcription`, `example`, `meaningExample`) VALUES ('"+id+"','"+spelling+"', '"+meaning+"', '"+transcription+"', '"+example+"', '"+meaningExample+"')" ;
           st.executeUpdate(query);
       } catch (Exception ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   /**
   * Update từ vào database
   */
   public void updateData(int id,String spelling, String meaning, String transcription, String example, String meaningExample){
        try {
            String query = "UPDATE `"+tableName+"` SET `spelling` = '"+spelling+"', `meaning` = '"+meaning+"', `transcription` = '"+transcription+"',"
                        + " `example` = '"+example+"', `meaningExample` = '"+meaningExample+"' WHERE `id` = '"+id+"'" ;
            st.executeUpdate(query);
       } catch (Exception ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public void deleteData(int id){
       try {
            String query = "DELETE FROM `"+tableName+"` WHERE `id`='"+id+"'";
            st.executeUpdate(query);
       } catch (Exception ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public void getAllTopic(){
       try {
           String query = "SELECT * FROM `topic`";
           rs = st.executeQuery(query);
            while (rs.next()) {
                int id  = rs.getInt("id");
                String topicName = rs.getString("name");
                topicName = topicName.trim();
                topic tp = new topic(id,topicName);
                topic.listTopic.add(tp);
            }
       } catch (Exception ex) {
           Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public void getWordByTopicID(int topic_id){
       try {
           String query = "SELECT * FROM `newWord` WHERE `topic_id` = '"+topic_id+"'";
           rs = st.executeQuery(query);
            while (rs.next()) {
                int id  = rs.getInt("id");
                String spelling         = rs.getString("spelling").trim();
                String meaning          = rs.getString("meaning").trim();
                String transcription    = rs.getString("transcription").trim();
                String 	example         = rs.getString("example").trim();
                String meaningExample   = rs.getString("meaningExample").trim();
                String define           = rs.getString("define").trim();
                String same             = rs.getString("same").trim();
                String type             = rs.getString("type").trim();
                int topic_ID            = rs.getInt("topic_id");
                
                newWord word = new newWord(id, spelling, meaning,transcription, example, 
                        meaningExample, define, same, type, topic_ID);
                topic.listWordTopic.add(word);
//                System.out.println(id + " " + spelling + " " + meaning + " " + transcription + " " +example + " " + meaningExample + " " + define + " " + same + " " + type + " " + topic_ID);
                
            }
       } catch (Exception ex) {
           Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
//    public static void main(String[] args) {
//        myConnect myconnect = new myConnect();
//        myconnect.getWordByTopicID(2);
//    }
}
