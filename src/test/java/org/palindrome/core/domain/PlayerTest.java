package org.palindrome.core.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player(1);
    }

    @Test
    public void constructorTest() {
        assertEquals("Player - constructor id", 1, player.getId());
        assertEquals("Player - constructor score", 0, player.getScore());
    }

    @Test
    public void addPalindromeTest() {
        player.addPalindrome(null);
        assertEquals("Player - add null palindrome", 0, player.getScore());
        player.addPalindrome("   ");
        assertEquals("Player - add empty palindrome", 0, player.getScore());

        player.addPalindrome("wow");
        assertEquals("Player - add wow palindrome", 3, player.getScore());
        player.addPalindrome("wow");
        assertEquals("Player - add second wow palindrome", 3, player.getScore());

        player.addPalindrome("а роза упала на лапу Азора");
        assertEquals("Player - add phrase palindrome", 29, player.getScore());
        player.addPalindrome("а роза упала на лапу Азора!!!!");
        assertEquals("Player - add phrase non-palindrome", 29, player.getScore());
    }

    @Test
    public void equalsTest() {
        assertEquals("Player - equals", Boolean.TRUE, player.equals(player));
        assertEquals("Player - equals", Boolean.TRUE, player.equals(new Player(1)));
        assertEquals("Player - equals", Boolean.FALSE, player.equals(new Player(2)));
        assertEquals("Player - equals for NULL", Boolean.FALSE, player.equals(null));

        assertEquals("Player - hashcode", player.getId(), player.hashCode());
    }

    @Test
    public void hashCodeTest() {
        assertEquals("Player - hashcode", player.getId(), player.hashCode());
    }
}
