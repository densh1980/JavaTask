package ua.epam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArithmeticTest {

    private Arithmetic a;

    @Before
    public  void runT() {
        a = new Arithmetic();
    }

    @Test
    public void testAdd() throws Exception {
        double res = a.add(3,7);
        Assert.assertEquals(10,res,0);
    }



    @Test
    public void testDeduct() throws Exception {
        double res =a.deduct(3,7);
        Assert.assertEquals(-4,res,0);
    }
    @Test
    public void testMult() throws Exception {
        double res =a.mult(3,7);
        Assert.assertEquals(21,res,0);
    }
    @Test
    public void testDiv() throws Exception {
        double res =a.div(10,3);
        Assert.assertEquals(3.3,res, 0.04);
    }

}