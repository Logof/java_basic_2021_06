package homework.hw03.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionText;
    private List<Answer> answers ;

    public Question(String questionText) {
        this.questionText = questionText;
        this.answers = new ArrayList<Answer>();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public int getAnswersCount(){
        return answers.size();
    }

    public boolean checkAnswer(int i) {
        return answers.get(i).isAnswerTrue();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(questionText);
        for (Answer answer: answers) {
            stringBuilder.append("\n"+answer.toString());
        }
        return stringBuilder.toString();
    }
}
