package dic.commandline;

public class Word {

    private String word_taget;
    private String word_explain;

    public Word() {
    }

    public Word(String word_taget, String word_explain) {
        this.word_taget = word_taget;
        this.word_explain = word_explain;
    }

    public Word(String lineInFile) {
        this.word_taget = lineInFile.substring(0, lineInFile.indexOf("\t"));
        this.word_explain = lineInFile.substring(lineInFile.indexOf("\t") + 1);
    }

    public String getWord_taget() {
        return word_taget;
    }

    public void setWord_taget(String word_taget) {
        this.word_taget = word_taget;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void printWord() {
        System.out.printf("%-20s%-20s\n", word_taget, word_explain);
    }
}
