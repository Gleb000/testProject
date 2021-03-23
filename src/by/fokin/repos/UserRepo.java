package by.fokin.repos;

import by.fokin.dto.User;
import by.fokin.repository.FileRepository;

import java.io.*;
import java.util.ArrayList;

public class UserRepo implements FileRepository {

    User checkUser = new User();
    ArrayList<User> userList = new ArrayList<>();

    boolean check = true;

    @Override
    public void save(User user) throws IOException, ClassNotFoundException {
        if (isEmpty()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userInfo.txt"));

            userList = (ArrayList<User>) objectInputStream.readObject();

            for (int i = 0; i < userList.size(); i++) {
                checkUser = userList.get(i);
                if ((checkUser.getFirstName().equals(user.getFirstName())) && checkUser.getLastName().equals(user.getLastName())) {
                    System.out.println("***");
                    System.out.println("Ошибка: пользователь существует!");
                    System.out.println("***");
                    System.out.println();
                    check = false;
                    break;
                }
            }

            objectInputStream.close();
        }

        if (check) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("userInfo.txt"));

            userList.add(user);
            objectOutputStream.writeObject(userList);

            objectOutputStream.close();
        }
    }

    @Override
    public boolean deleteUser(Integer id) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userInfo.txt"));

        userList = (ArrayList<User>) objectInputStream.readObject();

        try {
            userList.remove(id - 1);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("***");
            System.out.println("Ошибка: пользователь не найден!");
            System.out.println("***");
            System.out.println();

            objectInputStream.close();

            return false;
        }


        objectInputStream.close();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("userInfo.txt"));

        objectOutputStream.writeObject(userList);

        objectOutputStream.close();

        return true;


    }

    @Override
    public ArrayList<User> getAll() throws IOException, ClassNotFoundException {
        if (isEmpty()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userInfo.txt"));

            userList = (ArrayList<User>) objectInputStream.readObject();

            objectInputStream.close();
        }

        return userList;
    }

    @Override
    public boolean getOne(Integer id) throws IOException, ClassNotFoundException {
        if (isEmpty()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userInfo.txt"));

            userList = (ArrayList<User>) objectInputStream.readObject();


            try {
                User user = userList.get(id - 1);
                System.out.println();
                System.out.println("Информация о выбранном пользователе:");
                System.out.println("Имя: " + user.getFirstName());
                System.out.println("Фамилия: " + user.getLastName());
                System.out.println("Адрес электронной почты: " + user.getEmail());

                if (user.getRoles().size() > 1) {
                    System.out.println("Роли:");

                    for (int j = 0; j < user.getRoles().size(); j++) {
                        System.out.println(j + 1 + " роль: " + user.getRoles().get(j));
                    }
                } else {
                    System.out.println("Роль: " + user.getRoles().get(0));
                }

                if (user.getPhoneNumbers().size() > 1) {
                    System.out.println("Номера телефонов:");

                    for (int j = 0; j < user.getPhoneNumbers().size(); j++) {
                        System.out.println(j + 1 + " номер телефона: +" + user.getPhoneNumbers().get(j));
                    }
                } else {
                    System.out.println("Номер телефона: +" + user.getPhoneNumbers().get(0));
                }

                System.out.println();
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("***");
                System.out.println("Ошибка: пользователь не найден!");
                System.out.println("***");
                System.out.println();

                objectInputStream.close();

                return false;
            }

            objectInputStream.close();
        }

        return true;
    }

    @Override
    public void edit(ArrayList<User> users) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("userInfo.txt"));

        objectOutputStream.writeObject(users);

        objectOutputStream.close();
    }

    public boolean isEmpty() {
        File file = new File("userInfo.txt");

        return file.length() != 0;
    }
}