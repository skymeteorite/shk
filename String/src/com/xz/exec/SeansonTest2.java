package com.xz.exec;

/**
 * @ClassName SeansonTest2
 * @Description TODO
 * @Author xz
 * @Date 2020/5/9 15:34
 * @Version 1.0
 */

/*
使用enum关键字定义枚举类
定义的枚举类默认继承于java.lang.Enum
 */

public class SeansonTest2 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
    }
}

interface Info{
    void show();
}
enum Season1 implements Info{
    //1 提供当前枚举类的对象，多个对象之间用“，”隔开，末尾用“；”
    SPRING("春天", "chun"){
        @Override
        public void show() {
            System.out.println("spring");
        }
    },
    SUMMER("夏天", "xia") {
        @Override
        public void show() {
            System.out.println("summer");
        }
    },
    AUTUMN("秋天", "qiu") {
        @Override
        public void show() {
            System.out.println("autumn");
        }
    },
    WINTER("冬天", "dong") {
        @Override
        public void show() {
            System.out.println("winter");
        }
    };

    //2声明Season对象的属性，private final
    private final String seasonName;
    private final String seansonDesc;

    private Season1(String seasonName, String seansonDesc) {
        this.seasonName = seasonName;
        this.seansonDesc = seansonDesc;
    }
    //3 其他诉求，获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeansonDesc() {
        return seansonDesc;
    }



//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seansonDesc='" + seansonDesc + '\'' +
//                '}';
//    }
}
