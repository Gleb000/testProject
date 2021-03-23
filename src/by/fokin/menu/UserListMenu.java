package by.fokin.menu;

import by.fokin.dto.User;
import by.fokin.service.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class UserListMenu {
    UserService userService = new UserService();

    public void addUserListMenu() throws IOException, ClassNotFoundException {
        ArrayList<User> userList = userService.getUserList();
        User user = new User();

        if (userList.size() == 0) {
            System.out.println("***");
            System.out.println("Пользователи не найдены!");
            System.out.println("***");
            System.out.println();
        } else {
            for (int i = 0; i < userList.size(); i++) {
                user = userList.get(i);
                System.out.println((i + 1) + " пользователь:");
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
            }
        }
    }
}