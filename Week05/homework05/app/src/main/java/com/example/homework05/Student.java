package com.example.homework05;

public class Student {
    public String id;
    public String name;
    public String class_name;
    public Integer point;
    public Integer avatar;

    public Student(String id, String name, String class_name, Integer point, Integer avatar) {
        this.id = id;
        this.name = name;
        this.class_name = class_name;
        this.point = point;
        this.avatar = avatar;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getClass_name() {
        return class_name;
    }
    public Integer getPoint() {
        return point;
    }
    public Integer getAvatar() {
        return avatar;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }
    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }


}
