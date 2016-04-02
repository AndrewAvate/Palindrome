package org.palindrome.core.domain;

import java.util.HashSet;

import static org.palindrome.core.utils.CommonUtils.isPalindrome;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class Player {

    private final int id;
    private HashSet<String> palindromes;
    private volatile int score;
    private Board board;

    public Player(int id) {
        this.id = id;
        palindromes = new HashSet<>();
        board = Board.getInstance();
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public synchronized boolean addPalindrome(String word) {
        if (isPalindrome(word) && !palindromes.contains(word)) {
            score += word.length();
            palindromes.add(word);
            board.updateChampions(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null
                && obj instanceof Player
                && ((Player) obj).id == id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
