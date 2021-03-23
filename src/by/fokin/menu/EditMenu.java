package by.fokin.menu;

import by.fokin.dto.User;
import by.fokin.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class EditMenu {
    UserService userService = new UserService();
    FunctionMenu functionMenu = new FunctionMenu();

    String checkedString;

    public void addEditMenu() throws IOException, ClassNotFoundException {
        ArrayList<User> users = userService.getUserList();
        User user = new User();
        Integer id = 0;

        if (users.size() == 0) {
            System.out.println("***");
            System.out.println("Пользователи не найдены!");
            System.out.println("***");
            System.out.println();
        } else {
            while (true) {
                functionMenu.getUsersId(users);

                System.out.println("Выберите пользователя, которого хотите отредактировать");
                checkedString = functionMenu.enterStr();

                if (checkedString.equals("")) {
                    break;
                }

                if (Pattern.matches("\\A([0-9]+)\\Z", checkedString)) {
                    id = Integer.parseInt(checkedString);

                    if (userService.getOneUser(id)) {
                        break;
                    }
                }
            }

            user = users.get(id-1);

            while (true) {
                System.out.println("Выберите, что хотите изменить или нажмите Enter, чтобы выйти из редактора:");
                System.out.println("1) Имя");
                System.out.println("2) Фамилия");
                System.out.println("3) Адрес электронной почты");
                System.out.println("4) Роль");
                System.out.println("5) Номер телефона");
                checkedString = functionMenu.enterStr();

                if (checkedString.equals("")) {
                    if (userService.editUser(user, id, users)) {
                        break;
                    } else {
                        while (true) {
                            System.out.println("Выберите, что хотите изменить");
                            System.out.println("1) Имя");
                            System.out.println("2) Фамилия");
                            checkedString = functionMenu.enterStr();

                            if (Pattern.matches("\\A[1-2]\\Z", checkedString)) {
                                break;
                            } else {
                                System.out.println("***");
                                System.out.println("Ошибка: введено некорректное значение");
                                System.out.println("***");
                                System.out.println();
                            }
                        }
                    }
                }

                if (Pattern.matches("\\A[1-5]\\Z", checkedString)) {
                    Integer a = Integer.parseInt(checkedString);

                    switch (a) {
                        case 1:
                            while (true) {
                                System.out.println("Введите новое Имя:");
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
                            break;
                        case 2:
                            while (true) {
                                System.out.println("Введите новую Фамилию:");
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
                            break;
                        case 3:
                            while (true) {
                                System.out.println("Введите новый адрес электронной почты:");
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
                            break;
                        case 4:
                            functionMenu.chooseRole(user, checkedString);
                            break;
                        case 5:
                            ArrayList<String> numbers = user.getPhoneNumbers();

                            while (true) {
                                System.out.println("Выберите или нажмите Enter для выхода:");
                                System.out.println("1) Удалить номер телефона");
                                System.out.println("2) Добавить номер телефона");
                                checkedString = functionMenu.enterStr();

                                if (checkedString.equals("")) {
                                    user.setPhoneNumbers(numbers);
                                    break;
                                }

                                if (Pattern.matches("\\A[1-2]\\Z", checkedString)) {
                                    Integer b = Integer.parseInt(checkedString);

                                    switch (b) {
                                        case 1:
                                            if (numbers.size() > 1) {
                                                while (true) {
                                                    System.out.println("Записанные номера:");
                                                    for (int i = 0; i < numbers.size(); i++) {
                                                        System.out.println((i + 1) + " номер телефона: +" + numbers.get(i));
                                                    }
                                                    System.out.println("Выберите, который требуется удалить или нажмите Enter для выхода");
                                                    checkedString = functionMenu.enterStr();

                                                    if (checkedString.equals("")) {
                                                        break;
                                                    }

                                                    if (Pattern.matches("\\A[1-3]\\Z", checkedString)) {
                                                        Integer numberId = Integer.parseInt(checkedString);

                                                        if (numberId <= numbers.size()) {
                                                            numbers.remove(numberId - 1);
                                                            break;
                                                        } else {
                                                            System.out.println("***");
                                                            System.out.println("Некорректное значение, повторите ввод");
                                                            System.out.println("***");
                                                            System.out.println();
                                                        }
                                                    } else {
                                                        System.out.println("***");
                                                        System.out.println("Ошибка: введено некорректное значение");
                                                        System.out.println("***");
                                                        System.out.println();
                                                    }
                                                }
                                            } else {
                                                System.out.println("***");
                                                System.out.println("Невозможно выполнить");
                                                System.out.println("У вас записан лишь один номер телефона");
                                                System.out.println("***");
                                                System.out.println();
                                            }
                                            break;
                                        case 2:
                                            if (numbers.size() < 3) {
                                                functionMenu.addPhoneNumber(user, 2, checkedString);
                                            } else {
                                                System.out.println("***");
                                                System.out.println("Невозможно выполнить");
                                                System.out.println("Максимальное количество телефонов уже записано");
                                                System.out.println("***");
                                                System.out.println();
                                            }
                                            break;
                                    }
                                }
                            }
                            break;
                    }
                } else {
                    System.out.println("***");
                    System.out.println("Ошибка: введено некорректное значение");
                    System.out.println("***");
                    System.out.println();
                }
            }
        }
    }
}