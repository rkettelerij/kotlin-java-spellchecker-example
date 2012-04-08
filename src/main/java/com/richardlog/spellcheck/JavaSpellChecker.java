package com.richardlog.spellcheck;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class JavaSpellChecker {

    private static final File WORDS_DICTIONARY = new File("/usr/share/dict/words");

    private boolean checkSpelling(String input) throws IOException {
        Set<String> words = readDictionary();
        for (String word : input.toLowerCase().split(" ")) {
            if (!words.contains(word)) {
                System.out.println(word + " is not in the dictionary");
                return false;
            }
        }
        return true;
    }

    private Set<String> readDictionary() throws IOException {
        Set<String> words = new HashSet<String>();
        words.add("java"); // add java to dictionary
        InputStream stream = new FileInputStream(WORDS_DICTIONARY);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String word;
            while ((word = br.readLine()) != null) {
                words.add(word);
            }
        } finally {
            stream.close();
        }
        return words;
    }

    public static void main(String[] args) throws IOException {
        String defaultInput = "Java is an island";
        boolean valid = new JavaSpellChecker().checkSpelling(args.length > 0 ? args[0] : defaultInput);
        System.out.println("Is the text valid? " + valid);
    }
}
