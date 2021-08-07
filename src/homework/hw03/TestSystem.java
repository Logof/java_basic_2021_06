package homework.hw03;

import homework.hw03.entity.Answer;
import homework.hw03.entity.Question;

import java.io.*;
import java.util.*;

public class TestSystem {
    private int countQuestion;
    private int minAnswersCount;
    private int maxAnswersCount;

    private List<Question> questions;
    private int[] goodQuestions;

    public TestSystem(int countQuestion, int minAnswersCount, int maxAnswersCount) {
        this.countQuestion = countQuestion;
        this.minAnswersCount = minAnswersCount;
        this.maxAnswersCount = maxAnswersCount;
        this.questions = new ArrayList<Question>();

        this.goodQuestions = new int[countQuestion];
    }

    public void createTest() {
        System.out.println("Генерация теста");

        for (int i = 0; i < countQuestion; i++) {
            Question question = new Question("Вопрос № " + (i + 1));
            int countAnswer = (int) (Math.random() * (maxAnswersCount - minAnswersCount)) + minAnswersCount;
            int indexGoodAnswer = (int)( Math.random() * countAnswer );
            for (int j = 0; j < countAnswer; j++){
                question.addAnswer(new Answer(( (j + 1) + ((j == indexGoodAnswer)? ". Верный ": ". Неверный ") + "ответ "), (j == indexGoodAnswer)));
            }
            questions.add(question);
        }
    }

    public void testingUser() throws IOException {
        for(Question question : questions) {
            System.out.println(question.toString());

            int inputAnswer = -1;
            boolean correctAnswerInput = false;
            do {
                InputStream inputStream = System.in;
                Reader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String inputString = bufferedReader.readLine();

                correctAnswerInput = chekingInput(inputString, question.getAnswersCount());

                if (!correctAnswerInput) {
                    System.out.println("Введенный ответ - не корректен. Укажите правильный вариант ответа");
                } else {
                    inputAnswer = Integer.parseInt(inputString);
                }
            } while (!correctAnswerInput);

            if (question.checkAnswer(inputAnswer-1)) {
                goodQuestions[questions.indexOf(question)] = 1;
            }
        }
        System.out.println("Результат тестирования");
        testResult();

    }

    private boolean chekingInput(String input, int maxCount) {
        int answerNum = -1;
        try {
            answerNum = Integer.parseInt(input);
            if (answerNum < 1 || answerNum > maxCount) {
                return false;
            } else {
                return true;
            }

        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void testResult(){
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countQuestion; i++){
            if (goodQuestions[i] == 1 ){
                count += 1;
                if (count > 1) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(i+1);
            }
        }
        System.out.println("Кол-во верных ответов: " + count);
        System.out.println("Список вопросов с верными ответами: " + stringBuilder.toString());
    }
}
