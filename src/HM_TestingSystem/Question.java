package HM_TestingSystem;

public class Question {
    private String questionText;

    private String[] answers;
    private int index = 0;
    private int goodAnswer;

    @Override
    public String toString() {
        String result = "";

        result += this.questionText + '\n';
        for (int i = 0; i < answers.length; i++) {
            result += answers[i] + '\n';
        }
        return result;
    }


    public Question(String questionText, int countAnswers) {
        this.questionText = questionText;
        this.answers = new String[countAnswers];
    }

    public void addAnswer(String answer, boolean isGoodAnswer) {
        this.answers[index] = answer;

        if (isGoodAnswer) {
            goodAnswer = index;
        }
        index+=1;
    }


    public boolean checkAnswer(int i) {
        //System.out.println(goodAnswer + " " + i);
        return goodAnswer == i;
    }
}
