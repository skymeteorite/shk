package com.xz.exec;

/**
 * @ClassName SeansonTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/9 15:11
 * @Version 1.0
 */

/*
枚举类
1 类的对象只有有限个，确定个，
2 当需要定义一组常量时建议用
3 如果枚举类只有一个对象，可以用单例模式
 */
public class SeansonTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}


//自定义枚举类
class Season{
    //1 声明Seanson对象的属性：private final
    private final String seasonName;
    private final String seansonDesc;

    //2 私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seansonDesc) {
        this.seasonName = seasonName;
        this.seansonDesc = seansonDesc;
    }

    //3 提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "chun");
    public static final Season SUMMER = new Season("夏天", "xia");
    public static final Season AUTUMN = new Season("秋天", "qiu");
    public static final Season WINTER = new Season("冬天", "dong");

    //4 其他诉求，获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeansonDesc() {
        return seansonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seansonDesc='" + seansonDesc + '\'' +
                '}';
    }
}

