package com.company;

import java.io.IOException;
import java.util.Map;

class ChatBot implements BotInterface {
    @Override
    public void playGame(Map<String, String> dictionary, Map<Integer, String> arrOfWords, String user_name) {
        Game.playGame(dictionary, arrOfWords, user_name);
    }

    @Override
    public void speak(Map<Integer, String> phrases, Map<Integer, String> answers, Map<String, String> patterns, Map<String, String> answers_by_patterns) {
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
