package com.company;

import java.util.HashMap;

class Chat {
    private Readable reader = new Read();
    private HashMap<String,String> dictionary;
    private HashMap<Integer,String> arrOfWords;
    private HashMap<Integer, String> phrases;
    private HashMap<Integer, String> answers;
    private HashMap<String, String> patterns;
    private HashMap<String, String> answers_by_patterns;

    {
        try {
            dictionary = reader.makeDictionaryOfWords("C:\\Users\\nasty\\just_project\\src\\com\\dict.txt", " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            arrOfWords = reader.getArrayOfWords("C:\\Users\\nasty\\just_project\\src\\com\\dict.txt", " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            phrases = reader.makeListsOfPhrases("C:\\Users\\nasty\\just_project\\src\\com\\phrases.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            answers = reader.makeListsOfPhrases("C:\\Users\\nasty\\just_project\\src\\com\\answers.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            patterns = reader.makeDictionaryOfWords("C:\\Users\\nasty\\just_project\\src\\com\\patterns.txt", ":");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            answers_by_patterns = reader.makeDictionaryOfWords("C:\\Users\\nasty\\just_project\\src\\com\\answers_by_pattr.txt", ":");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void chat(){
        ChatBot bot = new ChatBot();
        bot.playGame(dictionary,arrOfWords);
        bot.speak(phrases,answers,patterns,answers_by_patterns);
    }
}
