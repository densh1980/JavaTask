package epam;

import org.junit.Assert;
import org.junit.Test;
import epam.Main;
import static org.junit.Assert.*;


public class MainTest {


    @Test
    public void emptyArray(){
        int[] src = {};
        int[] actual = Main.getInt(src,7);
        int[] expected = {};
        Assert.assertArrayEquals(expected,actual);
    }
    @Test
    public void srcArrayNoMatch(){
        int[] src = {1,2,3,4,5,6,7};
        int target = 8;
        int[] actual = Main.getInt(src,target);
        int[] expected = {};
        Assert.assertArrayEquals(expected,actual);
    }
    @Test
    public void multipleMatch(){
        int[] src = {8,8,0,-1,8,-1};
        int target = 8;
        int[] actual = Main.getInt(src,target);
        int[] expected = {0,1,4};
        Assert.assertArrayEquals(expected,actual);
    }
    @Test
    public void findFirst(){
        int[] src = {5,8,8,-1,-1,8};
        int target = 5;
        int[] actual = Main.getInt(src,target);
        int[] expected = {0};
        Assert.assertArrayEquals(expected,actual);
    }
    @Test
    public void findLast(){
        int[] src = {7,8,8,-1,-1,5};
        int target = 5;
        int[] actual = Main.getInt(src,target);
        int[] expected = {5};
        Assert.assertArrayEquals(expected,actual);
    }

}