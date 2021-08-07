package homework.hw03.entity;

public class Answer {
    private String answerText;
    private boolean answerTrue;

    public Answer(String answerText, boolean answerTrue) {
        this.answerText = answerText;
        this.answerTrue = answerTrue;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public String toString(){
        return answerText;
    }
}
