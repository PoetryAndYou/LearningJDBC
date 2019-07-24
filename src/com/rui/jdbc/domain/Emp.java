package com.rui.jdbc.domain;

/**
 * @author rui
 * @create 2019-07-24 12:33
 */
public class Emp {
    private String name;
    private Integer age;
    private Integer born;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", born=" + born +
                '}';
    }
}
