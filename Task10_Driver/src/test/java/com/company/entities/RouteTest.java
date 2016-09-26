package com.company.entities;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Denys_Shmyhin on 9/26/2016.
 */



public class RouteTest {

    private static Human nick;
    private static Human john;
    private static Driver rightDriver;
    private static Driver wrongDriver;
    private static GasolineCar car;


    @BeforeClass
    public static  void initRouteTest(){

        nick = new Human("Nick" , new Date() , Human.Gender.MALE , Human.BloodGroup.FIRST);
        john = new Human("John" , new Date() , Human.Gender.MALE , Human.BloodGroup.SECOND);

        rightDriver = new Driver(nick ,new DriverLicense(new Date() ,
                DriverLicense.Category.C , new Date()));
        wrongDriver = new Driver(john ,new DriverLicense(new Date() ,
                DriverLicense.Category.A , new Date()));

        car = new GasolineCar("ZAZ", "AA5555AA", "100500" , DriverLicense.Category.C ,
                1499 , 80 , GasolineCar.Transmission.AUTOMATIC);
    }
    @Test
    public void routePositiveTest(){
        Route route = new Route(car , rightDriver , "Troeshina" , "Klovska");
        String expectedResult = route.toString();
        Assert.assertTrue(expectedResult.contains(rightDriver.getHuman().toString())&&
                expectedResult.contains("from='Troeshina'")&&
                expectedResult.contains("where='Klovska'"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void RouteFailWrongDriverLicense(){

        Route route = new Route(car , wrongDriver , "Troeshina" , "Klovska");
    }

}