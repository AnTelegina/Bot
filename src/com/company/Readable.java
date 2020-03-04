package com.company;

import java.util.Map;

public interface Readable {
    Map<String,String> makeDictionaryOfWords(String fileName, String separator) throws Exception;

    Map<Integer,String> makeList(String fileName) throws Exception;

    Map<Integer,String> getArrayOfWords(String fileName, String separator) throws Exception;
}