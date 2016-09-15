package ua.epam;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    //default game  from 0 to 100
    private final static int MAX = 100;
    private final static int MIN = 0;
    private GameStatus gameStatus;
    private ArrayList gameLog = new ArrayList();

    enum GameStatus {IN_PROGRESS, GET_SUMMARY, FINISHED}

    private final int number;

    // left hand and right hand boundaries
    private int lha, rha;

    public GuessNumberGame() {
        number = randInt(MIN, MAX);
        lha = MIN;
        rha = MAX;
        gameStatus = GameStatus.IN_PROGRESS;
    }

    public boolean isGameInProgress() {
        return gameStatus == GameStatus.IN_PROGRESS || gameStatus == GameStatus.GET_SUMMARY;
    }

    public void nextTry() {
        if (gameStatus == GameStatus.IN_PROGRESS) {
            System.out.println("Попытка номер " + (gameLog.size() + 1));
            System.out.println("Введите число в диапазоне: [" + lha + "," + rha + "]");
            Scanner s = new Scanner(System.in);

            int possibleNumber;
            while (true) {

                if (!s.hasNextInt()) {
                    s.next();
                    System.out.println("Должно быть число ");
                    continue;
                }
                possibleNumber = s.nextInt();
                if (possibleNumber > rha || possibleNumber < lha) {
                    System.out.println("Должно быть число в диапазоне: [" + lha + "," + rha + "]");
                    continue;
                }
                break;
            }


            if (possibleNumber == number) {
                System.out.println("Вы угадали");
                gameStatus = GameStatus.GET_SUMMARY;
            } else if (possibleNumber > number) {
                rha = possibleNumber - 1;
            } else lha = possibleNumber + 1;

            gameLog.add(possibleNumber);

            if (lha == rha) {
                System.out.println("Вы проиграли. Осталось только одно число: " + lha);
                gameStatus = GameStatus.GET_SUMMARY;
            }

        } else {
            System.out.println(" Игра окончена \n");
            System.out.println("Загаданное число :" + number);
            printHistory();
            gameStatus = GameStatus.FINISHED;
        }
    }

    public void stopGame() {
        gameStatus = GameStatus.FINISHED;
    }

    private int randInt(int min, int max) {

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private void printHistory() {
        System.out.println("История ходов :");
        for (int i = 0; i < gameLog.size(); i++) {
            System.out.printf(" Попытка №%d число - %d \n", i + 1, gameLog.get(i));

        }
    }

}
