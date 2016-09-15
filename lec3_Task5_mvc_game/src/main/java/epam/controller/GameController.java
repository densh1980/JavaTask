package epam.controller;


import epam.model.GameModel;
import epam.model.GameStatus;
import epam.view.GameView;

import java.util.Scanner;

public class GameController {
    private GameModel model;
    private GameView view;
    private Scanner sc;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        sc = new Scanner(System.in);
    }

    public void run() {
        boolean flag = true;
        point: //main game loop

        do {
            switch (model.getGameStatus()) {

                case IN_PROGRESS:
                    view.showTryWelcomeMsg(model.getTryNumber(), model.getLeft(),model.getRight());
                    Integer input = readConsoleInput();
                    if (input == null) model.setGameStatus(GameStatus.STOP);
                    else if (!checkIfUserInputInRange(input, model.getLeft(), model.getRight())) {
                        view.inputOutOfRangeMsg(model.getLeft(), model.getRight());
                    } else {
                        switch (model.testUserNumber(input)){
                            case -1: //less case
                                view.showLessMsg();
                                break;
                            case 1: // more case
                                view.showMoreMsg();
                                break;
                            default:
                        };
                    }
                    ;
                    continue point;

                case STOP:
                    view.showQuitMsg();
                    flag = false;
                    break;
                case WIN:
                    view.showWinMsg();
                    flag = false;
                    break;
                case FINISHED:
                    view.showFinishedMsg();
                    flag = false;
                    break;
            }
        } while (flag);

        view.showNumber(model.getNumber());
        view.showHistory(model.getGameLog());
    }

    private boolean checkIfUserInputInRange(int input, int left, int right) {
        if (input > right || input < left) {

            return false;
        }
        return true;
    }
    public Integer readConsoleInput(){
        Integer result;
        while (true) {
            if (sc.hasNext("q")) return null;
            if (!sc.hasNextInt()) {
                sc.next();
                view.showMustBeNumer();
                continue;
            }
            result  = sc.nextInt();
            break;
        }
        return result;
    }
}
