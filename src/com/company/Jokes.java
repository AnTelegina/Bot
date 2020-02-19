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
        Random random = new Random();
        ArrayList<String> jks = new ArrayList<>();

        Document doc = Jsoup.connect("http://www.laughfactory.com/jokes/food-jokes").get();
        Elements jokes = doc.select("p[id]");
        for (Element e : jokes) {
            jks.add(e.text());
        }

        System.out.println(jks.get(random.nextInt(jks.size())));
    }
}
