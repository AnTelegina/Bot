package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class User {
    private String user_name;
    private HashMap<Integer, String> user_names = null;
    private Readable reader = new Read();
    private static Scanner str = new Scanner(System.in);
    private static String answer;

    User(String user_name){
        this.user_name = user_name;
        try { //читаем файл в словарь
            user_names = reader.makeList("C:\\Users\\nasty\\just_project\\src\\com\\stat\\user_names.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void check_user(){
        if (user_names.isEmpty()) // если словарь пуст, то добавляем имя текущего пользователя в файл
        {
            try(FileWriter writer = new FileWriter("C:\\Users\\nasty\\just_project\\src\\com\\stat\\user_names.txt", true))
            {
                writer.write(user_name + "\n");
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

        if (!user_names.containsValue(user_name) && !user_names.isEmpty()){ //если словарь не пуст, но не содержит имя пользователя, то дописываем в файл его имя
            try(FileWriter writer = new FileWriter("C:\\Users\\nasty\\just_project\\src\\com\\stat\\user_names.txt", true))
            {
                writer.write(user_name + "\n");
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    boolean name_is_already_existing(){
        return user_names.containsValue(user_name);
    }

    String continue_or_choose_another_name() {
        while (name_is_already_existing()) {
            System.out.println("Your name is already created. If you'd like to continue, write 'C', " +
                    "for choosing another name write 'N'");
            answer = str.nextLine();
            if (answer.equals("C")) break;
            if (answer.equals("N")) {
                System.out.println("Write another name!");
                user_name = str.nextLine();
            }
        }

        if (answer.equals("C")) return user_name;
        System.out.println("New name has been created.");
        check_user();
        return user_name;
    }
}
