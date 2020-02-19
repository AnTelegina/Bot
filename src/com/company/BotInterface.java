package com.company;

import java.io.IOException;
import java.util.HashMap;

public interface BotInterface {
     void playGame(HashMap<String, String> dictionary, HashMap<Integer, String> arrOfWords, String user_name);

     void speak(HashMap<Integer, String> phrases, HashMap<Integer, String> answers,
              HashMap<String, String> patterns, HashMap<String, String> answers_by_patterns);

     void show_statistics(String user_name);

     void make_a_joke() throws IOException;
}
