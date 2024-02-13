package com.models;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean class1;

    public Student() {

    }

    public Student(String name, String surname, boolean gender) {
        setName(name);
        setSurname(surname);
        setGender(class1);
    }

    public Student(int id, String name, String surname, boolean gender) {
        this(name, surname, class1);
        setId(id);
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

    public boolean getClass() {
        return class1;
    }

    public void setClass(boolean class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + (class1 ? "Male" : "Female") +
                '}';
    }
}