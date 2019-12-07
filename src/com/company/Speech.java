package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

class Speech {
    private static Scanner str = new Scanner(System.in);

    static void speak(HashMap<Integer, String> phrases, HashMap<Integer, String> answers,
                       HashMap<String, String> patterns, HashMap<String, String> answers_by_patterns){
        String answer;
        Random random = new Random();
        boolean match;

        while (true) {
            answer = str.nextLine();
            match = false;

            if (answer.toLowerCase().equals("finish") || answer.toLowerCase().equals("stop")) break;

            if (answer.toLowerCase().equals("\\help")) {
                System.out.println("");
                match = true;
            }

            String message = String.join(" ", answer.toLowerCase().split("[ {,|.}?]+"));
            for (Map.Entry<String, String> o : patterns.entrySet()) {
                Pattern pattern = Pattern.compile(o.getKey());
                if (pattern.matcher(message).find()) {
                    System.out.println(answers_by_patterns.get(o.getValue()));
                    match = true;
                }
            }
            if (!match) {
                if (answer.trim().endsWith("?")) {
                    System.out.println(answers.get(random.nextInt(answers.size())));
                } else {
                    System.out.println(phrases.get(random.nextInt(phrases.size())));
                }
            }
        }
    }
}
