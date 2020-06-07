package com.xz.exec;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateTimeTest
 * @Description
 * @Author xz
 * @Date 2020/5/8 16:32
 * @Version 1.0
 */
/*
jdk 1.8 之前的日期时间API测试
1 system类中currentTimeMillis()
2 java.util.Date和子类java.sql.Date
3 SimpleDateFormat
4 Calendar
 */
public class DateTimeTest {

    //Calendar 日历类（抽象类）的使用
    @Test
    public void testCalendar(){
        /*
        1 实例化
            1 创建子类GregorianCalendar 对象
            2 调用其静态方法getInstance()
         */
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        calendar.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));



    }



    //字符串"2020-09-08"转换为java.sql.Date
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
//        System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化 日期-》字符串
        Date date = new Date();
//        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程 字符串-》日期
        String str = "2020/1/8 下午4:50";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        //*******************************

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析
        Date date2 = sdf1.parse("2020.1.1 11:11:11");
        System.out.println(date2);
    }
}
