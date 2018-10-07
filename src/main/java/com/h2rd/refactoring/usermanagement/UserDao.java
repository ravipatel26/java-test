package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;

public class UserDao {

    private ArrayList<User> users = new ArrayList<User>();
    private static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void deleteUser(User userToDelete) {
        for (User user : users) {
            if (user.getName().equals(userToDelete.getName()))
                users.remove(user);
        }
    }

    public void updateUser(User userToUpdate) {
        for (User user : users) {
            if (user.getName().equals(userToUpdate.getName())) {
                user.setEmail(userToUpdate.getEmail());
                user.setRoles(userToUpdate.getRoles());
            }
        }
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }
}
