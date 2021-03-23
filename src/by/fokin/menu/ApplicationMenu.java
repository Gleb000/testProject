package by.fokin.menu;

import java.io.IOException;
import java.util.regex.Pattern;

public class ApplicationMenu {
    FunctionMenu functionMenu = new FunctionMenu();
    UserMenu userMenu = new UserMenu();
    EditMenu editMenu = new EditMenu();
    DeleteUserMenu deleteUserMenu = new DeleteUserMenu();
    UserListMenu userListMenu = new UserListMenu();
    GetOneUserMenu getOneUserMenu = new GetOneUserMenu();

    String checkedString;

    public void mainMenu() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1) Добавить пользователя");
            System.out.println("2) Редактировать пользователя");
            System.out.println("3) Список пользователей");
            System.out.println("4) Посмотерть информацию о пользователе");
            System.out.println("5) Удалить пользователя");
            System.out.println("6) Выход");
            checkedString = functionMenu.enterStr();

            if (check(checkedString)) {
                Integer a = Integer.parseInt(checkedString);
                switch (a) {
                    case 1:
                        userMenu.addUserMenu();
                        break;
                    case 2:
                        editMenu.addEditMenu();
                        break;
                    case 3:
                        userListMenu.addUserListMenu();
                        break;
                    case 4:
                        getOneUserMenu.addGetOneUser();
                        break;
                    case 5:
                        deleteUserMenu.addDeleteMenu();
                        break;
                    case 6:
                        System.out.println("Всего наилучшего!");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public boolean check(String checkedString) {
        if (Pattern.matches("\\A[1-6]\\Z", checkedString)) {
            return true;
        } else {
            System.out.println();
            System.out.println("***");
            System.out.println("Ошибка: введено некорректное значение! Повторите ввод");
            System.out.println("***");
            System.out.println();
            return false;
        }
    }
}