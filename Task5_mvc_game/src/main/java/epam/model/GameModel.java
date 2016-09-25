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

    public int testUserNumber(int userNumber) {
        //  -1 less  1 more 0 guess
        int result;

        // write log  only if game is still running
        if(gameStatus == GameStatus.IN_PROGRESS) gameLog.add(userNumber);

        if (userNumber == number) {
            gameStatus = GameStatus.WIN;
            return result = 0;

        } else if (userNumber > number) {
            rha = userNumber - 1;
            result = 1;
        } else {
            lha = userNumber + 1;
            result = -1;
        }

        //in case then interval reduce to one number finish game
        if (lha == rha) {
            gameStatus = GameStatus.FINISHED;
        }
        return result;
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


    // randInt must be private !!! for model TEST  make it  public
    public int randInt(int min, int max) {

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

}
