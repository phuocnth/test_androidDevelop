package com.example.myapplication.Model;

public class Employee {
    Integer id;
    String name, salary, age, img;

    public Employee(Integer id, String name, String salary, String age, String img) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Employee() {
    }
}

