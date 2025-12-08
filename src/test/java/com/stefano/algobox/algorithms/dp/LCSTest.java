package com.stefano.algobox.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSTest {

    @Test
    void testLCS() {
        assertEquals(4, LCS.lcs("AGGTAB", "GXTXAYB"), "LCS of AGGTAB and GXTXAYB should be 4");
        assertEquals(3, LCS.lcs("ABCDEF", "AEBDGH"), "LCS of ABCDEF and AEBDFG should be 3");
        assertEquals(0, LCS.lcs("ABC", "XYZ"), "LCS of ABC and XYZ should be 0");
    }

    @Test
    void testLCSWithEmptyString() {
        assertEquals(0, LCS.lcs("", ""), "LCS of two empty strings should be 0");
        assertEquals(0, LCS.lcs("ABC", ""), "LCS of ABC and an empty string should be 0");
        assertEquals(0, LCS.lcs("", "DEF"), "LCS of an empty string and DEF should be 0");
    }

    @Test
    void testLCSWithIdenticalStrings() {
        assertEquals(6, LCS.lcs("ABCDEF", "ABCDEF"), "LCS of identical strings should be the length of the string");
    }

    @Test
    void testLCSWithSingleCharacter() {
        assertEquals(1, LCS.lcs("A", "A"), "LCS of two identical single characters should be 1");
        assertEquals(0, LCS.lcs("A", "B"), "LCS of two different single characters should be 0");
    }
}
