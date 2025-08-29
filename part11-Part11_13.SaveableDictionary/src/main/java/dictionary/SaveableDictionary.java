package dictionary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SaveableDictionary {

    private final Map<String, String> dictionary;
    private final String file;
    private final Map<String, String> reverseDictionary;

    public SaveableDictionary(String file) {

        this.dictionary = new HashMap<>();
        this.file = file;
        this.reverseDictionary = new HashMap<>();

    }

    public SaveableDictionary() {
        this(null);
    }

    public void add(String words, String translation) {

        dictionary.put(words, translation);
        reverseDictionary.put(translation, words);

    }

    public String translate(String word) {

        if (word == null) return null;

        if (this.dictionary.containsKey(word)) return this.dictionary.get(word);

        return reverseDictionary.get(word);
    }

    public void delete(String word) {

        if (word == null) return;

        if (dictionary.containsKey(word)) {

            String toDelete = dictionary.remove(word);
            this.reverseDictionary.remove(toDelete);
        } else if (this.reverseDictionary.containsKey(word)) {

            String toDelete = reverseDictionary.remove(word);
            dictionary.remove(toDelete);
        }

    }

    public boolean load() {

        if (this.file == null) return false;

        try (Stream<String> lines = Files.lines(Paths.get(this.file))) {

            lines.map(line -> line.split(":", 2))
                    .filter(parts -> parts.length == 2)
                    .forEach(parts -> {

                        String word = parts[0].trim();
                        String translation = parts[1].trim();

                        dictionary.put(word, translation);
                        reverseDictionary.put(translation, word);
                    });
            return true;
        } catch (IOException ex) {

            return false;

        }

    }

    public boolean save() {

        if (this.file == null) return false;

        try (PrintWriter write = new PrintWriter(this.file)) {

            for (Map.Entry<String, String> entry : this.dictionary.entrySet()) {

                write.println(entry.getKey() + ":" + entry.getValue());

            }

            return true;
        } catch (Exception e) {

            return false;

        }

    }

    public void printDictionary() {

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}


