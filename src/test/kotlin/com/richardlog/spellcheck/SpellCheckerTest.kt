package com.richardlog.spellcheck

import org.junit.Test as test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class SpellCheckerTest {

    test fun javaSpellChecker() {
        val javaSpellChecker = JavaSpellChecker()
        assertTrue(javaSpellChecker.checkSpelling("This is valid text"))
        assertFalse(javaSpellChecker.checkSpelling("This is invalid teext"))
    }

    test fun kotlinSpellChecker() {
        val kotlinSpellChecker = JavaSpellChecker()
        assertTrue(kotlinSpellChecker.checkSpelling("This is valid text"))
        assertFalse(kotlinSpellChecker.checkSpelling("This is a invalid teext"))
    }

}