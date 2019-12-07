package com.company;

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
            phrases = reader.makeListsOfPhrases("C:\\Users\\nasty\\just_project\\src\\com\\dict\\phrases.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            answers = reader.makeListsOfPhrases("C:\\Users\\nasty\\just_project\\src\\com\\dict\\answers.txt");
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


    void chat(){
        String answer;
        ChatBot bot = new ChatBot();
        System.out.println("Hello! I'm simple Chat-Bot for studying English! If you'd like to test you English vocabulary, write 'play'. " +
                "If you'd like better to ask me smth, write 'speak'. " +
                "If you'd want to quit, write 'stop'.");

        while (true){
            answer = str.nextLine();

            if (answer.toLowerCase().equals("\\help")) {
                System.out.println("play: to test you vovabulary" + "\n" +
                        "speak: to speak or ask about smth" + "\n" +
                        "stop: to quit the game" + "\n");
            }
            if (answer.toLowerCase().equals("play"))
                bot.playGame(dictionary, arrOfWords);

            if (answer.toLowerCase().equals("speak")) {
                System.out.println("Pls write me smth!");
                bot.speak(phrases, answers, patterns, answers_by_patterns);
            }

            if (answer.toLowerCase().equals("stop")) break;
        }
    }
}
