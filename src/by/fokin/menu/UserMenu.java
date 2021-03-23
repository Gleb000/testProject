package by.fokin.menu;

import by.fokin.dto.User;
import by.fokin.service.UserService;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserMenu {
    FunctionMenu functionMenu = new FunctionMenu();
    UserService userService = new UserService();

    String checkedString;

    public void addUserMenu() throws IOException, ClassNotFoundException {
        User user = new User();

        while (true) {
            System.out.println("Введите Имя:");
            checkedString = functionMenu.enterStr();
            if ((Pattern.matches("\\A[А-Я]([а-я]+)\\Z", checkedString)) || (Pattern.matches("\\A[A-Z]([a-z]+)\\Z", checkedString))) {
                user.setFirstName(checkedString);
                break;
            } else {
                System.out.println();
                System.out.println("***");
                System.out.println("Ошибка: Имя введено некорректно! Повторите ввод");
                System.out.println("***");
                System.out.println();
            }
        }

        while (true) {
            System.out.println("Введите Фамилию:");
            checkedString = functionMenu.enterStr();
            if ((Pattern.matches("\\A[А-Я]([а-я]+)\\Z", checkedString)) || (Pattern.matches("\\A[A-Z]([a-z]+)\\Z", checkedString))) {
                user.setLastName(checkedString);
                break;
            } else {
                System.out.println();
                System.out.println("***");
                System.out.println("Ошибка: Фамилия введена некорректно! Повторите ввод");
                System.out.println("***");
                System.out.println();
            }
        }

        while (true) {
            System.out.println("Введите адрес электронной почты:");
            checkedString = functionMenu.enterStr();
            if (Pattern.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", checkedString)){
                user.setEmail(checkedString);
                break;
            } else {
                System.out.println();
                System.out.println("***");
                System.out.println("Ошибка: адрес электронной почты введен некорректно! Повторите ввод");
                System.out.println("***");
                System.out.println();
            }
        }

        functionMenu.chooseRole(user, checkedString);

        functionMenu.addPhoneNumber(user, 1, checkedString);

        userService.addUser(user);
    }
}