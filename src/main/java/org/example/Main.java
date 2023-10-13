package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserManager userManager = new UserManager();

        userManager.readFile();

        User user = new User();
        user.setId(6);
        user.setUsername("Test User");
        userManager.saveFile(user);
    }
}