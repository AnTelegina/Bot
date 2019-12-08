package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class User {
    void check_user(String user_name){
        Readable reader = new Read();
        HashMap<Integer, String> user_names = null;
        
        try { //читаем файл в словарь
            user_names = reader.makeList("C:\\Users\\nasty\\just_project\\src\\com\\stat\\user_names.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
}
