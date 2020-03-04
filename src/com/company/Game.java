package com.company;

import java.util.Map;
import java.util.Scanner;

class Game {
    private static int score = 0;
    private static Scanner str = new Scanner(System.in);

    static void playGame(Map<String, String> dictionary, Map<Integer, String> arrOfWords, String user_name){
        String answer;
        User user = new User(user_name);

        int count = arrOfWords.size(); //размер словаря, по которому проверяем слова

        for (int i = 0; i < count; i++) {
            //String randomWord = arrOfWords.get(random.nextInt(arrOfWords.size()));
            String word = arrOfWords.get(i);  //на каждой итерации выводим последовательно слова из списка
            System.out.println(word);
            answer = str.nextLine().toLowerCase(); // читаем ответ от пользователя

            if (answer.toLowerCase().equals("\\help")) {
                System.out.println("stop: to quit the game");
            }

            if (answer.toLowerCase().equals("stop") || answer.toLowerCase().equals("finish")) break;

            if (answer.toLowerCase().equals(dictionary.get(word))) { //проверяем корректость ответа, если все правильно, то score++
                System.out.println("Correct!");
                score++;
            }
            else System.out.println("Incorrect!");
        }
        System.out.println("Your score is: " + score + " from " + count); //выводим количество правильных ответов
        user.write_in_file(user_name, score);
    }

    static void show_statistics(String user_name){
        User user = new User(user_name);
        user.read_from_file(user_name);
    }
}
