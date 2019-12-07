package com.company;

import java.util.HashMap;

public interface Readable {
    HashMap<String,String> makeDictionaryOfWords(String fileName, String separator) throws Exception;

    HashMap<Integer,String> makeListsOfPhrases(String fileName) throws Exception;

    HashMap<Integer,String> getArrayOfWords(String fileName, String separator) throws Exception;
}
