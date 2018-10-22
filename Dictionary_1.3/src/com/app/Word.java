package com.app;
/**
 * @author phixuanhoan
 */
public class Word {
    private String word_target;
    private String word_explain;
    
    public Word(String word_target, String word_explain){
        this.word_target    = word_target;
        this.word_explain   = word_explain;
    }
    /**
     * @return the word_target
     */
    public String getWord_target() {
        return word_target;
    }

    /**
     * @param word_target the word_target to set
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * @return the word_explain
     */
    public String getWord_explain() {
        return word_explain;
    }

    /**
     * @param word_explain the word_explain to set
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    
}
