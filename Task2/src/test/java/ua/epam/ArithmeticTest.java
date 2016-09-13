package ua.epam;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class ArithmeticTest {

    private static Arithmetic a;
    @Rule
    public final ExpectedException exp = ExpectedException.none();
    @Rule
    public  final Timeout time = Timeout.millis(1000);

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
    @Test
    public void testDivByZero(){
        exp.expect(ArithmeticException.class);
        a.div(10.0,0.0);
    }
    @Test
    public void timeTest(){

    }


}