package HM_TestingSystem;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static final int Q_COUNT = 5;
    static final int MIN_COUNT_ANSWERS = 2;
    static final int MAX_COUNT_ANSWERS = 5;


    static ArrayList<Question> questionArray = new ArrayList<>();

    public static void createQuestions() {
        for (int i = 0; i < Q_COUNT; i ++) {

            int countAnswer = (int) (Math.random() * (MAX_COUNT_ANSWERS - MIN_COUNT_ANSWERS)) + MIN_COUNT_ANSWERS;

            Question question = new Question("Вопрос #"+ (i + 1), countAnswer);

            int indexGoodAnswer = (int)( Math.random() * countAnswer );
            //System.out.println(indexGoodAnswer);

            for (int j = 0; j < countAnswer; j++){
                question.addAnswer(( (j + 1) + ((j == indexGoodAnswer)? ". Верный ": ". Неверный ") + "ответ "), (j == indexGoodAnswer));
            }
            questionArray.add(question);

        }
    }

    public static void runTesting() {
        int goodAnswerCount = 0;
        int[] goodQuestion = new int[Q_COUNT];

        for (int i = 0; i < Q_COUNT; i ++) {

            Question question = questionArray.get(i);

            System.out.println(question.toString());

            int answerNum = 0;
            do {
                InputStream inputStream = System.in;
                Reader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                try {
                    answerNum = Integer.parseInt(bufferedReader.readLine());
                    if (answerNum < 1 || answerNum > 5) {
                        System.out.println("Ответ не корректен. Попробуйте еще раз\n");
                    } else {
                        System.out.println("Ответ " + answerNum + " принят\n");
                    }

                    if (question.checkAnswer(answerNum -1)) {
                        goodQuestion[goodAnswerCount] = i + 1;
                        goodAnswerCount +=1;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Ответ не корректен. Попробуйте еще раз\n");
                }catch (IOException ex) {
                    System.out.println("Ответ не корректен. Попробуйте еще раз\n");
                }

            } while (answerNum < 1 || answerNum > 5);
        }

        System.out.println("Кол-во верных ответов: " + goodAnswerCount);
        if (goodAnswerCount != 0) {
            String goodQuestionList = "";
            for (int j = 0; j < goodAnswerCount; j++) {
                if (j != 0) {
                    goodQuestionList += ", ";
                }
                goodQuestionList += goodQuestion[j];
            }
            System.out.println("Список вопросов с верными ответами: " + goodQuestionList);
        }
    }

    public static void main(String[] args) {
	    createQuestions();
        runTesting();
    }
}
