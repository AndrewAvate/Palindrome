package org.palindrome.core.domain;

import java.util.HashSet;

import static org.palindrome.core.utils.CommonUtils.isPalindrome;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class Player {

    private final int id;
    private HashSet<String> palindromes;
    private int score;

    public Player(int id) {
        this.id = id;
        palindromes = new HashSet<String>();
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean addPalindrome(String word) {
        if (isPalindrome(word) && !palindromes.contains(word)) {
            score += word.length();
            palindromes.add(word);
            return true;
        }
        return false;
    }
}
