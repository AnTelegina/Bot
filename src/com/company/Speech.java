package com.company;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

class Speech {
    private static Scanner str = new Scanner(System.in);
    private static boolean match;
    public Speech(){
        match = false;
    }

    static void speak(Map<Integer, String> phrases, Map<Integer, String> answers,
                       Map<String, String> patterns, Map<String, String> answers_by_patterns){
        Random random = new Random();

        while (true) {
            String answer;
            answer = str.nextLine();

            if (answer.toLowerCase().equals("\\help")) {  // command "help"
                System.out.println("stop: to finish the conversation");
                match = true;
            }

            if (answer.toLowerCase().equals("finish") || answer.toLowerCase().equals("stop")) break; // если ответ "stop", прекращаем разговор с ботом

            match = find_pattern_in_dictionary(patterns, answers_by_patterns, answer);

            if (!match) {
                if (answer.trim().endsWith("?")) { // смотрим,есть ли в конце предложения "?"
                    System.out.println(answers.get(random.nextInt(answers.size()))); // если есть, то выводим какой-либо ответ
                } else {
                    System.out.println(phrases.get(random.nextInt(phrases.size()))); // если знака "?", то выводим просто какую-либо фразу
                }
            }
        }
    }

    private static boolean find_pattern_in_dictionary(Map<String, String> patterns, Map<String, String> answers_by_patterns, String answer){
        String message = String.join(" ", answer.toLowerCase().split("[ {,|.}?]+")); // проверяем, можно провести соотвествие введенной фразы
        //какому-либо шаблону
        for (Map.Entry<String, String> o : patterns.entrySet()) {
            Pattern pattern = Pattern.compile(o.getKey());
            if (pattern.matcher(message).find()) { // если нашли совпадение, то выводим ответ на фразу
                System.out.println(answers_by_patterns.get(o.getValue()));
                match = true;
            }
        }
        return match;
    }
}
