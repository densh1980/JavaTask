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

}