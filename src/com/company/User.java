package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class User {
    private String user_name;
    private HashMap<Integer, String> user_names = null;
    private static Scanner str = new Scanner(System.in);
    private static String answer;

    User(String user_name){
        this.user_name = user_name;
        try { //читаем файл в словарь
            Readable reader = new Read();
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
            make_file_for_user(user_name);
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
            make_file_for_user(user_name);
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

    private void make_file_for_user(String user_name){
        File newFile = new File("C:\\Users\\nasty\\just_project\\src\\com\\stat\\" + user_name + ".txt");
        try
        {
            newFile.createNewFile();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    void write_in_file(String user_name, Integer score){
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        try(FileWriter writer = new FileWriter("C:\\Users\\nasty\\just_project\\src\\com\\stat\\" + user_name + ".txt", true))
        {
            writer.write(date + " " + score + "\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    void read_from_file(String user_name){
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\nasty\\just_project\\src\\com\\stat\\" + user_name + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
