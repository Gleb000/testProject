package by.fokin.menu;

import by.fokin.dto.User;
import by.fokin.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class GetOneUserMenu {
    UserService userService = new UserService();
    FunctionMenu functionMenu = new FunctionMenu();

    String checkedString;

    public void addGetOneUser() throws IOException, ClassNotFoundException {
        ArrayList<User> userList = userService.getUserList();
        User user = new User();

        if (userList.size() == 0) {
            System.out.println("***");
            System.out.println("Пользователи не найдены!");
            System.out.println("***");
            System.out.println();
        } else {
            functionMenu.getUsersId(userList);

            while (true) {
                System.out.println("Введите номер пользователя, о котором хотите узнать полную информацию:");
                checkedString = functionMenu.enterStr();

                if (Pattern.matches("\\A([0-9]+)\\Z", checkedString)) {
                    Integer a = Integer.parseInt(checkedString);

                    if (userService.getOneUser(a)) {
                        break;
                    }
                } else {
                    System.out.println("***");
                    System.out.println("Ошибка: введено некорректное значение!");
                    System.out.println("***");
                    System.out.println();
                }
            }
        }
    }
}