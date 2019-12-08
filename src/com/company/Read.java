package com.company;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

class Read implements Readable {
    @Override
    public HashMap<String, String> makeDictionaryOfWords(String fileName, String separator) throws Exception {
        HashMap<String, String> dict = new HashMap<>();
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
    public HashMap<Integer, String> makeList(String fileName) throws Exception {
        HashMap<Integer, String> dict = new HashMap<>();
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
    public HashMap<Integer, String> getArrayOfWords(String fileName, String separator) throws Exception {
        HashMap<Integer, String> arr = new HashMap<>();
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