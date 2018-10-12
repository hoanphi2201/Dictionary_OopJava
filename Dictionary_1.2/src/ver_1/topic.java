/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ver_1;

import java.util.ArrayList;

/**
 *
 * @author phixuanhoan
 */
public class topic {
    public static ArrayList<topic> listTopic = new ArrayList();
    public static ArrayList<newWord> listWordTopic = new ArrayList();
    private int id;
    private String topicName;
    myConnect myconnect = new myConnect();
    public topic(int id, String topic){
        this.id = id;
        this.topicName = topic;
    }
    public topic(){
        this.id = 0;
        this.topicName = "";
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the topicName
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * @param topicName the topicName to set
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    public void getAllTopic(){
        myconnect.getAllTopic();
    }
    public void getWordByTopicID(int id){
        myconnect.getWordByTopicID(id);
    }
}

