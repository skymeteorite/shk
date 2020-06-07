package com.xz.dao;

import java.util.*;

/**
 * @ClassName DAO
 * @Description data(base) access object
 * @Author xz
 * @Date 2020/5/13 13:05
 * @Version 1.0
 */
public class DAO<T> {//表的共性操作DAO

    private Map<String,T> map = new HashMap<>();
    //保存T类型的对象到Map成员变量中
    public void save(String id, T entity){
        map.put(id, entity);
    }
    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换map中的value
    public void update(String id, T entity){
        if (map.containsKey(id)){
            map.put(id, entity);
        }
    }
    //返回map中存放的所有T对象
    public List<T> list(){
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values){
            list.add(t);
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
