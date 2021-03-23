package by.fokin;

import by.fokin.menu.ApplicationMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ApplicationMenu applicationMenu = new ApplicationMenu();

        applicationMenu.mainMenu();
    }
}