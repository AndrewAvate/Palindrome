package org.palindrome.core.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.palindrome.core.utils.CommonUtils.isPalindrome;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class CommonUtilsTest {

    @Test
    public void isPalindromeTest() {
        assertEquals("CommonUtils.isPalindrome - palindrome", Boolean.TRUE, isPalindrome("wow"));
        assertEquals("CommonUtils.isPalindrome - not palindrome", Boolean.FALSE, isPalindrome("wov"));

        assertEquals("CommonUtils.isPalindrome - palindrome cyrillic phrase", Boolean.TRUE, isPalindrome("а роза упала на лапу Азора"));
        assertEquals("CommonUtils.isPalindrome - no palindrome cyrillic phrase", Boolean.FALSE, isPalindrome("а роза упала на лапу АзорРРа"));

        assertEquals("CommonUtils.isPalindrome - empty", Boolean.FALSE, isPalindrome("   "));
        assertEquals("CommonUtils.isPalindrome - null", Boolean.FALSE, isPalindrome(null));

    }
}
