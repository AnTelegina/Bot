package com.company;

import java.util.HashMap;
import java.util.Scanner;

class Game {
    private static int score;
    private static Scanner str = new Scanner(System.in);

    static void playGame(HashMap<String, String> dictionary, HashMap<Integer, String> arrOfWords){
        String answer;
        int count = arrOfWords.size(); //размер словаря, по которому проверяем слова

        for (int i = 0; i < count; i++) {
            //String randomWord = arrOfWords.get(random.nextInt(arrOfWords.size()));
            String word = arrOfWords.get(i);  //на каждой итерации выводим последовательно слова из списка
            System.out.println(word);
            answer = str.nextLine(); // читаем ответ от пользователя
            if (answer.toLowerCase().equals("stop") || answer.toLowerCase().equals("finish")) break;

            if (answer.toLowerCase().equals(dictionary.get(word))) { //проверяем корректость ответа, если все правильно, то score++
                System.out.println("Correct!");
                score++;
            }
            else System.out.println("Incorrect!");
        }
        System.out.println("Your score is: " + score + " from " + count); //выводим количество правильных ответов
    }
}
