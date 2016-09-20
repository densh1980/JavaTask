package epam.controller;


import epam.model.GameModel;
import epam.view.GameView;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

    }

    public void run() {
        boolean flag = true;
        point:

        do {
            switch (model.getGameStatus()) {

                case IN_PROGRESS:
                    view.showTryWelcomeMsg(model.getTryNumber(), model.getCurrentInterval());
                    Integer input = view.readConsoleInput();
                    if (input == null) model.setGameStatus(GameModel.GameStatus.STOP);
                    else if(!checkIfUserInputInRange(input,model.getLeft(),model.getRight())) {
                        view.inputOutOfRangeMsg(model.getLeft(),model.getRight());
                    }else {
                        model.testUserNumber(input);
                    };

                    continue point;

                case STOP:
                    view.showQuitMsg();
                    flag = false;
                    break ;
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
    private boolean checkIfUserInputInRange(int input,int left,int right){
        if ( input > right || input < left) {
            //view.inputOutOfRangeMsg(left,right);
            return false;
        }
        return true;
    }
}
