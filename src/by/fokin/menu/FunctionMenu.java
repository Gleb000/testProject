package by.fokin.menu;

import by.fokin.dto.Role;
import by.fokin.dto.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FunctionMenu {
    String checkedString;

    public String enterStr() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ввод >> ");

        checkedString = scanner.nextLine();
        System.out.println();

        return checkedString;
    }

    public void getUsersId(ArrayList<User> users) {
        User user = new User();

        for (int i = 0; i < users.size(); i++) {
            user = users.get(i);
            System.out.println((i + 1) + " пользователь:");
            System.out.print("Имя: " + user.getFirstName() + "   Фамилия: " + user.getLastName());
            System.out.println();
            System.out.println();
        }
    }

    public void chooseRole(User user, String checkedString) {
        ArrayList<String> roleList = new ArrayList<>();
        Integer a = 0;

        while (true) {
            System.out.println("Выберите роль:");
            System.out.println("1) " + Role.USER + "  (1 уровень)");
            System.out.println("2) " + Role.CUSTOMER + "  (1 уровень)");
            System.out.println("3) " + Role.ADMIN + "  (2 уровень)");
            System.out.println("4) " + Role.PROVIDER + "  (2 уровень)");
            System.out.println("5) " + Role.SUPER_ADMIN + "  (3 уровень)");
            checkedString = enterStr();

            if (Pattern.matches("\\A[1-5]\\Z", checkedString)) {
                a = Integer.parseInt(checkedString);

                switch (a) {
                    case 1:
                        roleList.add(String.valueOf(Role.USER));
                        System.out.println("Выберите еще одну роль, либо нажмите Enter, чтобы пропустить");
                        System.out.println("1) " + Role.ADMIN + "  (2 уровень)");
                        System.out.println("2) " + Role.PROVIDER + "  (2 уровень)");
                        if (!checkedString.equals("")) {
                            while (true) {
                                checkedString = enterStr();

                                if (Pattern.matches("\\A[1-2]\\Z", checkedString)) {
                                    a = Integer.parseInt(checkedString);

                                    switch (a) {
                                        case 1:
                                            roleList.add(String.valueOf(Role.ADMIN));
                                            break;
                                        case 2:
                                            roleList.add(String.valueOf(Role.PROVIDER));
                                            break;
                                    }

                                    break;
                                } else {
                                    System.out.println("***");
                                    System.out.println("Ошибка: введено некорректное значение! Повторите ввод");
                                    System.out.println("***");
                                    System.out.println();
                                }
                            }
                        }
                        break;
                    case 2:
                        roleList.add(String.valueOf(Role.CUSTOMER));
                        System.out.println("Выберите еще одну роль, либо нажмите Enter, чтобы пропустить");
                        System.out.println("1) " + Role.ADMIN + "  (2 уровень)");
                        System.out.println("2) " + Role.PROVIDER + "  (2 уровень)");
                        if (!checkedString.equals("")) {
                            while (true) {
                                checkedString = enterStr();

                                if (Pattern.matches("\\A[1-2]\\Z", checkedString)) {
                                    a = Integer.parseInt(checkedString);

                                    switch (a) {
                                        case 1:
                                            roleList.add(String.valueOf(Role.ADMIN));
                                            break;
                                        case 2:
                                            roleList.add(String.valueOf(Role.PROVIDER));
                                            break;
                                    }

                                    break;
                                } else {
                                    System.out.println("***");
                                    System.out.println("Ошибка: введено некорректное значение! Повторите ввод");
                                    System.out.println("***");
                                    System.out.println();
                                }
                            }
                        }
                        break;
                    case 3:
                        roleList.add(String.valueOf(Role.ADMIN));
                        System.out.println("Выберите еще одну роль, либо нажмите Enter, чтобы пропустить");
                        System.out.println("1) " + Role.USER + "  (1 уровень)");
                        System.out.println("2) " + Role.CUSTOMER + "  (1 уровень)");
                        if (!checkedString.equals("")) {
                            while (true) {
                                checkedString = enterStr();

                                if (Pattern.matches("\\A[1-2]\\Z", checkedString)) {
                                    a = Integer.parseInt(checkedString);

                                    switch (a) {
                                        case 1:
                                            roleList.add(String.valueOf(Role.USER));
                                            break;
                                        case 2:
                                            roleList.add(String.valueOf(Role.CUSTOMER));
                                            break;
                                    }
                                    break;
                                } else {
                                    System.out.println("***");
                                    System.out.println("Ошибка: введено некорректное значение! Повторите ввод");
                                    System.out.println("***");
                                    System.out.println();
                                }
                            }
                        }
                        break;
                    case 4:
                        roleList.add(String.valueOf(Role.PROVIDER));
                        System.out.println("Выберите еще одну роль, либо нажмите Enter, чтобы пропустить");
                        System.out.println("1) " + Role.USER + "  (1 уровень)");
                        System.out.println("2) " + Role.CUSTOMER + "  (1 уровень)");
                        if (!checkedString.equals("")) {
                            while (true) {
                                checkedString = enterStr();

                                if (Pattern.matches("\\A[1-2]\\Z", checkedString)) {
                                    a = Integer.parseInt(checkedString);

                                    switch (a) {
                                        case 1:
                                            roleList.add(String.valueOf(Role.USER));
                                            break;
                                        case 2:
                                            roleList.add(String.valueOf(Role.CUSTOMER));
                                            break;
                                    }

                                    break;
                                } else {
                                    System.out.println("***");
                                    System.out.println("Ошибка: введено некорректное значение! Повторите ввод");
                                    System.out.println("***");
                                    System.out.println();
                                }
                            }
                        }
                        break;
                    case 5:
                        roleList.add(String.valueOf(Role.SUPER_ADMIN));
                        break;
                }
            } else {
                System.out.println("***");
                System.out.println("Ошибка: введено некорректное значение! Повторите ввод");
                System.out.println("***");
                System.out.println();
            }

            if (roleList.size() > 0) {
                user.setRoles(roleList);
                break;
            }
        }
    }

    public void addPhoneNumber(User user, Integer operationNumber, String checkedString) {
        ArrayList<String> phoneNumList = new ArrayList<>();
        Integer counter = 0;
        boolean repeat = false;

        if (operationNumber == 1) {
            while (true) {
                System.out.println("Введите номер телефона:");
                checkedString = enterStr();

                if (Pattern.matches("\\A[3][7][5](\\d{2})\\s(\\d{7})\\Z", checkedString)) {
                    phoneNumList.add(checkedString);
                    counter++;
                    break;
                } else {
                    System.out.println("***");
                    System.out.println("Ошибка: номер телефона должен быть в формате 375xx xxxxxxx");
                    System.out.println("***");
                    System.out.println();
                }
            }
        } else {
            phoneNumList = user.getPhoneNumbers();
            counter = user.getPhoneNumbers().size();
        }

        while (true) {
            repeat = false;

            System.out.println("Введите еще один номер телефона или нажмите Enter для выхода");
            checkedString = enterStr();

            if (checkedString.equals("")) {
                user.setPhoneNumbers(phoneNumList);
                break;
            }

            if (Pattern.matches("\\A[3][7][5](\\d{2})\\s(\\d{7})\\Z", checkedString)) {
                for (int i = 0; i < phoneNumList.size(); i++) {
                    if (checkedString.equals(phoneNumList.get(i))) {
                        repeat = true;
                    }
                }

                if (repeat) {
                    System.out.println("***");
                    System.out.println("Ошибка: номера не могут повторяться!");
                    System.out.println("***");
                    System.out.println();
                } else {
                    phoneNumList.add(checkedString);
                    counter++;
                }
            } else {
                System.out.println("***");
                System.out.println("Ошибка: номер телефона должен быть в формате 375xx xxxxxxx");
                System.out.println("***");
                System.out.println();
            }

            if (counter == 3) {
                user.setPhoneNumbers(phoneNumList);
                break;
            }
        }
    }
}