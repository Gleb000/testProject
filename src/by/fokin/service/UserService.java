package by.fokin.service;

import by.fokin.dto.User;
import by.fokin.repos.UserRepo;

import java.io.IOException;
import java.util.ArrayList;

public class UserService {
    UserRepo userRepo = new UserRepo();

    public void addUser(User user) throws IOException, ClassNotFoundException {
        userRepo.save(user);
    }

    public ArrayList<User> getUserList() throws IOException, ClassNotFoundException {
        return userRepo.getAll();
    }

    public boolean deleteUser(Integer id) throws IOException, ClassNotFoundException {
        return userRepo.deleteUser(id);
    }

    public boolean getOneUser(Integer id) throws IOException, ClassNotFoundException {
        return userRepo.getOne(id);
    }

    public boolean editUser(User user, Integer id, ArrayList<User> users) throws IOException {
        boolean isExists = true;

        for (int i = 0; i < users.size(); i++) {
            if (i != id - 1) {
                if (users.get(i).getFirstName().equals(user.getFirstName()) && users.get(i).getLastName().equals(user.getLastName())) {
                    isExists = false;
                }
            }
        }

        if (isExists) {
            users.set(id - 1, user);

            userRepo.edit(users);

            return true;
        } else {
            System.out.println("***");
            System.out.println("ПОЛЬЗОВАТЕЛЬ НЕ СОХРАНЕН!");
            System.out.println("Пользователь с такими именем и фамилией уже существует");
            System.out.println("***");
            System.out.println();
        }

        return false;
    }
}