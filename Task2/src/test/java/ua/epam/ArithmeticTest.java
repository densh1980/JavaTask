package ua.epam;

import org.junit.*;

import static org.junit.Assert.*;


public class ArithmeticTest {

    private static Arithmetic a;

    @BeforeClass
    public static  void runT() {
        a = new Arithmetic();
    }

    @Test
    public void testAdd() {
        double res = a.add(3,7);
        Assert.assertEquals(10,res,0);
    }


    @Ignore
    @Test
    public void testDeduct() {
        double res =a.deduct(3,7);
        Assert.assertEquals(-4,res,0);
    }
    @Test
    public void testMult() {
        double res =a.mult(3,7);
        Assert.assertEquals(21,res,0);
    }
    @Test
    public void testDiv() {
        double res =a.div(10,3);
        Assert.assertEquals(3.3,res, 0.04);
    }
    @Test(expected = ArithmeticException.class )
    public void testDivByZero(){
         a.div(10.0,0.0);
    }
    @Test(timeout = 1000)
    public void timeTest(){

    }

}