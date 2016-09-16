package epam.model;

import com.sun.javafx.sg.prism.NGShape;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Denys_Shmyhin on 9/16/2016.
 */
public class GameModelTest {
    public static GameModel model;

    @Before
    public void setUpModel() {
        model = new GameModel();
    }

    //test random function
    @Test
    public void randIntTest() {

        int tryCount = 10000; //number of tries
        int left = 1;
        int right = 99;
        while (tryCount-- > 0) {
            int actual = model.randInt(left, right);
            Assert.assertTrue(actual >= left && actual <= right);
        }
    }

    //test MORE case
    @Test
    public void testUserNumberCaseMore() {
        final int MORE = 1;
        int numberForTst = model.getNumber() + 1;
        int actual = model.testUserNumber(numberForTst);
        Assert.assertTrue(actual == MORE && model.getGameStatus() == GameStatus.IN_PROGRESS);
    }

    //test LESS case
    @Test
    public void testUserNumberCaseLess() {
        final int LESS = -1;
        int numberForTst = model.getNumber() - 1;
        int actual = model.testUserNumber(numberForTst);
        Assert.assertTrue(actual == LESS && model.getGameStatus() == GameStatus.IN_PROGRESS);
    }

    //test EQUAL
    @Test
    public void testUserNumberCaseEqual() {
        final int EQUAL = 0;
        int numberForTst = model.getNumber();
        int actual = model.testUserNumber(numberForTst);
        Assert.assertTrue(actual == EQUAL && model.getGameStatus() == GameStatus.WIN);
    }

}