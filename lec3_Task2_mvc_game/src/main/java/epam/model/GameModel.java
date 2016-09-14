package epam.model;

import java.util.ArrayList;
import java.util.Random;


public class GameModel {

    // interval
    private final static int MAX = 99;
    private final static int MIN = 1;



    // left hand and right hand boundaries
    private int lha;



    private int rha;




    // number can be guessed
    private int number;

    ArrayList gameLog;
    GameStatus gameStatus;

    public GameModel() {
        number = randInt(MIN, MAX);
        lha = MIN;
        rha = MAX;
        gameStatus = GameStatus.IN_PROGRESS;
        gameLog = new ArrayList();
    }

    public boolean testUserNumber(int userNumber) {

        gameLog.add(userNumber);

        if (userNumber == number) {
            gameStatus = GameStatus.WIN;
            return true;
        } else if (userNumber > number) {
            rha = userNumber - 1;
        } else lha = userNumber + 1;

        //if interval reduce to one number
        if (lha == rha) {
            gameStatus = GameStatus.FINISHED;
            return true;
        }
        return false;
    }

    public int getTryNumber() {
        return gameLog.size()+1;
    }

    public int[] getCurrentInterval() {

        return new int[]{lha, rha};
    }

    public GameStatus getGameStatus() {

        return gameStatus;
    }

    public void setGameStatus(GameStatus st) {
        gameStatus = st;
    }


    public ArrayList getGameLog() {

        return gameLog;
    }


    public void stopGame() {
        gameStatus = GameStatus.STOP;
    }

    private int randInt(int min, int max) {

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    public int getNumber() {
        return number;
    }
    public int getLeft() {
        return lha;
    }
    public int getRight() {
        return rha;
    }

    public static enum GameStatus { WIN,IN_PROGRESS,STOP,FINISHED}
}
