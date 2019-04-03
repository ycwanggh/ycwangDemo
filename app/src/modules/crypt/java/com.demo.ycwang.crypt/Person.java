package com.demo.ycwang.ycwangdemo.crypt;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/15 11:48
 */
public class Person {

    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
