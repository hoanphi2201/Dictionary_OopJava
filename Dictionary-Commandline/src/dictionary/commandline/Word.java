package dictionary.commandline;
/**
 *
 * @author GotTheRuns
 */
public class Word {
    private String word_target;
    private String word_explain;
    // Constructor
    public Word(String word_taget, String word_explain) {
        this.word_target = word_taget;
        this.word_explain = word_explain;
    }
    /**
     * @return the word_target
     */
    public String getWord_taget() {
        return word_target;
    }

    /**
     * @param word_target
     */
    public void setWord_taget(String word_taget) {
        this.word_target = word_taget;
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
    // print a word format
    public void printWord() {
        System.out.printf("%-20s%-20s\n", getWord_taget(), getWord_explain());
    }
}
