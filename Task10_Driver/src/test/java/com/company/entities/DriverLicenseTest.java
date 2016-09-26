package com.company.entities;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Denys_Shmyhin on 9/26/2016.
 */
public class DriverLicenseTest {
    DriverLicense.Category cat =  DriverLicense.Category.A;
    Calendar cal = Calendar.getInstance();

    @Test
    public void createDriverLicensePositive(){

        cal.set(2012,11,1);
        Date fromDate = cal.getTime();
        cal.set(2016,11,1);
        Date expires = cal.getTime();
        DriverLicense lic  =  new DriverLicense(expires, cat, fromDate);
        Assert.assertTrue(lic.getCategories().contains(cat) &&
                lic.getExpires().compareTo(expires)== 0 &&
                lic.getFromDate().compareTo(fromDate)== 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void createDriverLicenseNegative_fromDateBeforeExpiried(){

        cal.set(2016,11,1);
        Date fromDate = cal.getTime();
        cal.set(2012,11,1);
        Date expires = cal.getTime();
        DriverLicense lic  =  new DriverLicense(expires, cat, fromDate);

    }

}