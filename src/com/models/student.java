package com.models;

import static java.lang.String.*;

public class Student {
    private int id;
    private String name;
    private String surname;
    private boolean class1;
//Create a Student class with attributes id ,name ,surname.class1
    public Student(int id, String name, String surname, boolean class1) {

    }

    public Student(String name, String name1, String surname) {

    }


    public void Student() {

    }

    public void Student(String name, String surname, boolean class1) {
        setName(name);
        setSurname(surname);
        setClass(class1);
    }

    public void Student(int id, String name, String surname, boolean class1) {
        this(name, valueOf(class1), surname);
        setId(id);
    }

    public void Student(String name, String surname, String class1) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean getClass() {
        return class1;
    }

    public void setClass(boolean class1) {
        this.class1 = class1;
    }


    //Make an output of id,name ,surname,class
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", class=" + (class1 ? "SE-2311" : "IT-2301" ) +
                '}';
    }
}