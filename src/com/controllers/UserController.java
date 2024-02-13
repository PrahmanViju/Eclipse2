package com.controllers;

import com.models.student;
import repositories.interfaces.IstudentRepository;

import java.util.List;

public class studentController {
    private IstudentRepository repo;

    public void studentController(IstudentRepository repo) {
        this.repo = repo;
    }

    public String createstudent(String name, String surname, String class1) {
        boolean se = class1.toLowerCase().equals("SE-2311");
        Student student = new student(name, surname, class1);

        boolean created = repo.createstudent(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getstudent(int id) {
        User user = repo.getstudent(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllstudent() {
        List<Student> users = repo.getAllstudent();

        StringBuilder response = new StringBuilder();
        for (Student student : students) {
            response.append(student.toString()).append("\n");
        }

        return response.toString();
    }
}