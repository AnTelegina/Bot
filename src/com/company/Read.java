package com.company;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Read implements Readable {
    @Override
    public Map<String, String> makeDictionaryOfWords(String fileName, String separator) throws Exception {
        Map<String, String> dict = new HashMap<>();
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        String[] subStr;

        while (scan.hasNextLine()){
            subStr = scan.nextLine().split(separator);
            dict.put(subStr[0], subStr[1]);
        }

        fr.close();
        return dict;
    }

    @Override
    public Map<Integer, String> makeList(String fileName) throws Exception {
        Map<Integer, String> dict = new HashMap<>();
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        int count = 0;

        while (scan.hasNextLine()){
            dict.put(count, scan.nextLine());
            count++;
        }

        fr.close();
        return dict;
    }

    @Override
    public Map<Integer, String> getArrayOfWords(String fileName, String separator) throws Exception {
        Map<Integer, String> arr = new HashMap<>();
        FileReader fr = new FileReader(fileName);
        Scanner scan = new Scanner(fr);
        String[] subStr;
        int count = 0;

        while (scan.hasNextLine()){
            subStr = scan.nextLine().split(separator);
            arr.put(count, subStr[0]);
            count++;
        }

        fr.close();
        return arr;
        }
}