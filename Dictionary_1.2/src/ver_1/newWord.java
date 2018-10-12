/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ver_1;

import javax.swing.ImageIcon;

/**
 *
 * @author phixuanhoan
 * spelling: nội dung từ -> tenTu
 * explain: nghĩa của từ ->nghiaTu
 * transcription -> phienAm
 * example : câu ví dụ -> cau vi du
 * explainExample : ->nghia cau vi du
 */
public class newWord {
    // id của từ
    private int  id;
    //    Biến tên của từ mới
    private String spelling;
    //    Biến nghĩa của từ mới
    private String explain;
    //    Biến phiên âm của từ
    private String transcription;
    //    Biến câu ví dụ
    private String example;
    //    Biến nghĩa của câu ví dụ
    private String explainExample;
    private String define;
    private String same;
    private String type;
    private int topic_id;
    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExlainExample() {
        return explainExample;
    }

    public void setExplainExample(String explainExample) {
        this.explainExample = explainExample;
    }
    public newWord(int id, String spelling, String explain, String transcription, 
            String example, String explainExample){
        this.id             = id;
        this.spelling       = spelling;
        this.explain        = explain;
        this.transcription  = transcription;
        this.example        = example;
        this.explainExample = explainExample;
    }
    public newWord(int id, String spelling, String explain, String transcription,
            String example, String explainExample, String define, String same, String type, int topic_id){
        this.id             = id;
        this.spelling       = spelling;
        this.explain        = explain;
        this.transcription  = transcription;
        this.example        = example;
        this.explainExample = explainExample;
        this.define         = define;
        this.same           = same;
        this.type           = type;
        this.topic_id       =topic_id;
    }
    public newWord(){
        this.spelling       = "";
        this.explain        = "";
        this.transcription  = "";
        this.example        = "";
        this.explainExample = "";
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
     * @return the define
     */
    public String getDefine() {
        return define;
    }

    /**
     * @param define the define to set
     */
    public void setDefine(String define) {
        this.define = define;
    }

    /**
     * @return the same
     */
    public String getSame() {
        return same;
    }

    /**
     * @param same the same to set
     */
    public void setSame(String same) {
        this.same = same;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the topic_id
     */
    public int getTopic_id() {
        return topic_id;
    }

    /**
     * @param topic_id the topic_id to set
     */
    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}
