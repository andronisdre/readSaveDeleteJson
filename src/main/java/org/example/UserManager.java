package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class UserManager {
    private Map<String, User> userList;
    private String fileName = "src/main/user.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public UserManager() {
    }

    public void readFile() throws IOException {
        Type type = new TypeToken<Map<String, User>>(){}.getType();
        Reader reader = new FileReader(new File(fileName));
        userList = gson.fromJson(reader, type);

        System.out.println("User List:");
        for(String name : userList.keySet()) {
            System.out.println("Key: " + name);
        }
    }


    public void saveFile(User user) throws IOException {
        userList.put(user.getUsername(), user);
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(userList, fw);
        fw.close();
        System.out.println("User " + Main.getUserNameString() + " saved!");
    }

    public void removeFile(User user) throws IOException {
        userList.remove(Main.getUserNameString());
        FileWriter fw = new FileWriter(new File(fileName));
        gson.toJson(userList, fw);
        fw.close();
        System.out.println("user " + Main.getUserNameString() + " removed!");
    }









}


