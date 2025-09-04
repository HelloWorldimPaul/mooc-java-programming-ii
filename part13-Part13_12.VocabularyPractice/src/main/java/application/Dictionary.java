package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dictionary {

    HashMap<String, String> translations;
    List<String> words;

    public Dictionary() {

        this.translations = new HashMap<>();
        this.words = new ArrayList<>();

       this.translations.put("oten","dick");
       this.words.add("oten");

    }

    public void addWord(String word, String translation) {

        if (!this.translations.containsKey(word)) {

            this.words.add(word);

        }

        this.translations.put(word, translation);

    }

    public String getTranslation(String word) {

        return this.translations.get(word);

    }

    public String getRandom(){

        Random random = new Random();

        return this.words.get(random.nextInt(this.words.size()));


    }

}

