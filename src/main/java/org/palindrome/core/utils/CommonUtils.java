package org.palindrome.core.utils;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class CommonUtils {

    public static boolean isPalindrome(String word) {
        if (null == word) {
            return false;
        }
        String trimmedString = word.replaceAll(" ", "");

        if (trimmedString.equals("")) {
            return false;
        }

        String reverseTrimmedString = new StringBuilder(trimmedString).reverse().toString();
        return trimmedString.equalsIgnoreCase(reverseTrimmedString);
    }
}
