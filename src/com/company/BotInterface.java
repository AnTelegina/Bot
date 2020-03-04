package com.company;

import java.io.IOException;
import java.util.Map;

public interface BotInterface {
     void playGame(Map<String, String> dictionary, Map<Integer, String> arrOfWords, String user_name);

     void speak(Map<Integer, String> phrases, Map<Integer, String> answers,
                Map<String, String> patterns, Map<String, String> answers_by_patterns);

     void show_statistics(String user_name);

     void make_a_joke() throws IOException;
}