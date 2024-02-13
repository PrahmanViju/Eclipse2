package com.controllers;

import com.models.User;
import repositories.interfaces.IstudentRepository;

import java.util.List;

public class UserController {
    private final IstudentRepository repo;

    public studentController(IstudentRepository repo) {
        this.repo = repo;
    }

    public String createstudent(String name, String surname, String class1) {
        boolean se = class1.toLowerCase().equals("SE-2311");
        User user = new User(name, surname, class1);

        boolean created = repo.createstudent(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getstudent(int id) {
        User user = repo.getstudent(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllstudent() {
        List<User> users = repo.getAllstudent();

        StringBuilder response = new StringBuilder();
        for (User user : users) {
            response.append(user.toString()).append("\n");
        }

        return response.toString();
    }
}