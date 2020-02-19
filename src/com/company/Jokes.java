package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import org.jsoup.select.Elements;
import java.lang.String;
import java.util.ArrayList;
import java.util.Random;

class Jokes {
    static void make_a_joke() throws IOException {
       // System.out.println("Joke!");
        Random random = new Random();
        ArrayList<String> jks = new ArrayList<>();

        Document doc = Jsoup.connect("http://www.laughfactory.com/jokes/food-jokes").get();
        String title = doc.title();
        Elements jokes = doc.select("p[id]");
        for (Element e : jokes) {
            //System.out.println(e.text());
            jks.add(e.text());
        }



       // for (String i : jks)
         //   System.out.println(i);

        System.out.println(jks.get(random.nextInt(jks.size())));
    }
}
