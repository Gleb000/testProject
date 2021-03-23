package by.fokin.repository;

import by.fokin.dto.User;

import java.io.IOException;
import java.util.ArrayList;

public interface FileRepository {
    void save(User user) throws IOException, ClassNotFoundException;

    boolean deleteUser(Integer id) throws IOException, ClassNotFoundException;

    ArrayList<User> getAll() throws IOException, ClassNotFoundException;

    boolean getOne(Integer id) throws IOException, ClassNotFoundException;

    void edit(ArrayList<User> users) throws IOException;
}