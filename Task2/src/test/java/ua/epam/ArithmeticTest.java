package ua.epam;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArithmeticTest {
    @Test
    public void testAdd() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.add(3,7);
        Assert.assertTrue(res==10);

    }
    @Test
    public void testDeduct() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.deduct(3,7);
        Assert.assertTrue(res == -4);
    }
    @Test
    public void testMult() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.mult(3,7);
        Assert.assertTrue(res == 21);
    }
    @Test
    public void testDiv() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.div(10,5);
        Assert.assertTrue(res == 2);
    }

}