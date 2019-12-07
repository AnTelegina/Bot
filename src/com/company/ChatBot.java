package com.company;

import java.util.HashMap;

class ChatBot implements BotInterface {
    @Override
    public void playGame(HashMap<String, String> dictionary, HashMap<Integer, String> arrOfWords) {
        Game.playGame(dictionary, arrOfWords);
    }

    @Override
    public void speak(HashMap<Integer, String> phrases, HashMap<Integer, String> answers, HashMap<String, String> patterns, HashMap<String, String> answers_by_patterns) {
        Speech.speak(phrases,answers,patterns,answers_by_patterns);
    }
}
