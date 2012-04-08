package com.richardlog.spellcheck

import java.io.*
import java.io.File
import java.util.Set

class KotlinSpellChecker {

    private val WORDS_DICTIONARY = File("/usr/share/dict/words");

    fun checkSpelling(input : String) : Boolean {
        val words = readDictionary()
        for (word in input.toLowerCase().split(" ")) {
            if (!words.contains(word)) {
                println("$word is not in the dictionary");
                return false;
            }
        }
        return true;
    }

    private fun readDictionary() : Set<String> {
        val words = hashSet<String>("kotlin") // add kotlin to dictionary
        val stream = FileInputStream(WORDS_DICTIONARY).buffered();
        try {
            val br = InputStreamReader(stream, "UTF-8");
            br.forEachLine( { words.add(it)} )
        } finally {
            stream.close();
        }
        return words;
    }
}

fun main(args : Array<String>) {
    val defaultInput = "Kotlin is an island"
    val valid = KotlinSpellChecker().checkSpelling(if (args.size > 0) args[0] else defaultInput)
    println("Is the text valid? $valid")
}

