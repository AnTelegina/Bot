package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Chat {
    private Readable reader = new Read();
    private HashMap<String,String> dictionary;
    private HashMap<Integer,String> arrOfWords;
    private HashMap<Integer, String> phrases;
    private HashMap<Integer, String> answers;
    private HashMap<String, String> patterns;
    private HashMap<String, String> answers_by_patterns;
    private static Scanner str = new Scanner(System.in);

    {
        try {
            dictionary = reader.makeDictionaryOfWords("C:\\Users\\nasty\\just_project\\src\\com\\dict\\dict.txt", " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            arrOfWords = reader.getArrayOfWords("C:\\Users\\nasty\\just_project\\src\\com\\dict\\dict.txt", " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            phrases = reader.makeList("C:\\Users\\nasty\\just_project\\src\\com\\dict\\phrases.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            answers = reader.makeList("C:\\Users\\nasty\\just_project\\src\\com\\dict\\answers.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            patterns = reader.makeDictionaryOfWords("C:\\Users\\nasty\\just_project\\src\\com\\dict\\patterns.txt", ":");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            answers_by_patterns = reader.makeDictionaryOfWords("C:\\Users\\nasty\\just_project\\src\\com\\dict\\answers_by_pattr.txt", ":");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void chat() throws IOException {
        String answer;
        String user_name;
        ChatBot bot = new ChatBot();

        System.out.println("Hello! I'm simple Chat-Bot for studying English! Tell me please you user name: ");
        user_name = str.nextLine();
        User user = new User(user_name);
        user.check_user();
        if (user.name_is_already_existing())
            user_name = user.continue_or_choose_another_name();

        System.out.println("Now we are ready to start! White \\help, if you need it.");

        while (true){
            answer = str.nextLine().toLowerCase();

           switch (answer){
               case "\\help":
                   System.out.println("play: to test you vocabulary" + "\n" +
                           "speak: to speak or ask about smth" + "\n" +
                           "stop: to quit the game" + "\n" +
                           "show stat: to show your personal progress in Learning" + "\n" +
                           "joke: to read a joke in English");
                   break;

               case "show stat":
                   bot.show_statistics(user_name);
                   break;

               case "speak":
                   System.out.println("Pls write me smth!");
                   bot.speak(phrases, answers, patterns, answers_by_patterns);
                   System.out.println("What now?");
                   break;

               case "play":
                   bot.playGame(dictionary, arrOfWords, user_name);
                   System.out.println("What now?");
                   break;
               case "joke":
                   bot.make_a_joke();
                   break;
           }

            if (answer.toLowerCase().equals("stop")) break;
        }
    }
}
