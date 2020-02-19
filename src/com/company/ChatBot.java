package com.company;

import java.io.IOException;
import java.util.HashMap;

class ChatBot implements BotInterface {
    @Override
    public void playGame(HashMap<String, String> dictionary, HashMap<Integer, String> arrOfWords, String user_name) {
        Game.playGame(dictionary, arrOfWords, user_name);
    }

    @Override
    public void speak(HashMap<Integer, String> phrases, HashMap<Integer, String> answers, HashMap<String, String> patterns, HashMap<String, String> answers_by_patterns) {
        Speech.speak(phrases,answers,patterns,answers_by_patterns);
    }

    @Override
    public void show_statistics(String user_name) {
        Game.show_statistics(user_name);
    }

    @Override
    public void make_a_joke() throws IOException {
        Jokes.make_a_joke();
    }
}
