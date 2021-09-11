package homework.hw03.entity;

public class Answer {
    private final String answerText;
    private final boolean answerTrue;

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
