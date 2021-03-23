package by.fokin.menu;

import by.fokin.dto.User;
import by.fokin.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DeleteUserMenu {
    UserService userService = new UserService();
    FunctionMenu functionMenu = new FunctionMenu();

    String checkedString;

    public void addDeleteMenu() throws IOException, ClassNotFoundException {
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
                System.out.println("Введите номер пользователя, которого хотите удалить или Enter для выхода в главное меню");
                checkedString = functionMenu.enterStr();
                if (!checkedString.equals("")) {
                    if (Pattern.matches("\\A([0-9]+)\\Z", checkedString)) {
                        Integer a = Integer.parseInt(checkedString);

                        boolean check = userService.deleteUser(a);

                        if (check) {
                            break;
                        }
                    } else {
                        System.out.println("***");
                        System.out.println("Ошибка: введено некорректное значение!");
                        System.out.println("***");
                        System.out.println();
                    }
                } else {
                    break;
                }
            }
        }
    }
}