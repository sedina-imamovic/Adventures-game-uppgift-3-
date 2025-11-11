package se.sprinto.hakan.adventuregame.view;

import java.util.Scanner;

public class ScannerUI implements UI {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}

