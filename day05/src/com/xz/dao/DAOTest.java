package com.xz.dao;

import java.util.List;

/**
 * @ClassName DAOTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/13 13:12
 * @Version 1.0
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1001, 23, "Tom"));
        dao.save("1002", new User(1002, 24, "Jack"));
        dao.save("1003", new User(1003, 25, "Fed"));

        dao.update("1003", new User(1003, 33, "Feb"));
        dao.delete("1002");

        List<User>list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);
    }

}
