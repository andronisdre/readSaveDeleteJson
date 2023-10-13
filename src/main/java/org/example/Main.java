package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static String userNameString;
    public static void main(String[] args) throws IOException {
        UserManager userManager = new UserManager();

        userManager.readFile();

        System.out.println("do you want to add or remove a user?");
        System.out.println("press 1 to add, 2 to remove");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("enter your username");
            User user = new User();
            user.setId(6);
            userNameString = input.next();
            user.setUsername(userNameString);
            userManager.saveFile(user);
        } else {
            System.out.println("enter id of user");
            //userNameString = input.next();
            userManager.removeFile();
            System.out.println("you removed user");
        }
    }
}