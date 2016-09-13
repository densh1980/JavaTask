package ua.epam;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArithmeticTest {
    @Test
    public void testAdd() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.add(3,7);
        if(res !=10) Assert.fail();
    }
    @Test
    public void testDeduct() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.deduct(3,7);
        if(res !=-4) Assert.fail();
    }
    @Test
    public void testMult() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.mult(3,7);
        if(res !=21) Assert.fail();
    }
    @Test
    public void testDiv() throws Exception {
        Arithmetic a = new Arithmetic();
        double res =a.div(10,5);
        if(res !=2) Assert.fail();
    }

}