package com.company;

import java.util.HashMap;

public interface BotInterface {
     void playGame(HashMap<String, String> dictionary, HashMap<Integer, String> arrOfWords);

     void speak(HashMap<Integer, String> phrases, HashMap<Integer, String> answers,
              HashMap<String, String> patterns, HashMap<String, String> answers_by_patterns);
}
