package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here

        String testFile = "test_dictionary.txt";

        // 1. Create dictionary and add words
        SaveableDictionary dict = new SaveableDictionary(testFile);
        dict.add("kissa", "cat");
        dict.add("koira", "dog");
        dict.add("olut", "beer");

        // 2. Translate tests
        System.out.println("Translate 'kissa': " + dict.translate("kissa")); // cat
        System.out.println("Translate 'cat': " + dict.translate("cat"));     // kissa

        // 3. Delete test
        dict.delete("koira");
        System.out.println("After deleting 'koira':");
        dict.printDictionary();

        // 4. Save to file
        if (dict.save()) {
            System.out.println("Dictionary saved successfully.");
        } else {
            System.out.println("Failed to save dictionary.");
        }

        // 5. Load into new dictionary
        SaveableDictionary loadedDict = new SaveableDictionary(testFile);
        if (loadedDict.load()) {
            System.out.println("File loaded successfully.");
            loadedDict.printDictionary();
        } else {
            System.out.println("Failed to load dictionary.");
        }

        // 6. Translate from loaded dictionary
        System.out.println("Translate 'olut': " + loadedDict.translate("olut")); // beer
        System.out.println("Translate 'beer': " + loadedDict.translate("beer"));

    }
}
