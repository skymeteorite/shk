package com.xz.exec;

import org.junit.Test;

import java.util.Date;

public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        Date date = new Date(2020, 9, 8);
        System.out.println(date);//Fri Oct 08 00:00:00 GMT+08:00 3920
    }
}
