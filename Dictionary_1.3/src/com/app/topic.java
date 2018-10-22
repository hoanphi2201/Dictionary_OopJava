package com.app;

import com.app.wordTopic;
import com.model.myConnect;
import java.util.ArrayList;
/**
 *
 * @author phixuanhoan
 */
public class topic {
    public static ArrayList<topic> listTopic = new ArrayList();
    public static ArrayList<wordTopic> listWordTopic = new ArrayList();
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
}

