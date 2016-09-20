package  epam;
import epam.controller.GameController;
import epam.model.GameModel;
import epam.view.GameView;

public class GameRunner {

    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController game = new GameController(model,view);
        game.run();

    }
}
