package sample;

public class Word {
    private String wordeXplain;
    private String wordTarget;
    public Word(){}
    public Word(String wordTarget , String wordeXplain){
        this.wordeXplain = wordeXplain;
        this.wordTarget = wordTarget;
    }
    public String getWord_target(){
        return wordTarget;
    }
    public void setWord_target(String wordTarget){
        this.wordTarget=wordTarget;
    }
    public String getWord_explain(){
        return wordeXplain;
    }
    public void setWord_explain(String wordeXplain){
        this.wordeXplain=wordeXplain;
    }
}
