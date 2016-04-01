package org.palindrome.core.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class PlayerTest {

    @Test
    public void testPlayer() throws NoSuchFieldException {
        Player player = new Player(1);
        assertEquals("Player - constructor id", 1, player.getId());
        assertEquals("Player - constructor score", 0, player.getScore());

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

        assertEquals("Player - not change id", 1, player.getId());
    }
}
