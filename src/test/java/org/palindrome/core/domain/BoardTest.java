package org.palindrome.core.domain;

import org.junit.Before;
import org.junit.Test;
import org.palindrome.core.dao.DaoManager;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewavetisov on 01.04.16.
 */

public class BoardTest {

    private Board board;

    @Before
    public void setup() throws NoSuchFieldException {
        board = Board.getInstance();
        //clean context
        DaoManager.getDao().removePlayers();

    }

    @Test
    public void getInstanceTest() {
        assertEquals("Board - constructor", Board.getInstance(), board);
    }

    @Test
    public void updateChampionsTest() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
        Player player4 = new Player(4);
        Player player5 = new Player(5);
        Player player6 = new Player(6);

        player1.addPalindrome("wow");
        board.updateChampions(player1);
        assertEquals("Board - updateChampions 1", 0, board.getChampions().indexOf(player1));
        assertEquals("Board - updateChampions 1", 1, board.getChampions().size());

        //call addPalindrome out of addPalindrome
        player2.addPalindrome("wowow");
        assertEquals("Board - updateChampions 2", 0, board.getChampions().indexOf(player2));
        assertEquals("Board - updateChampions 2", 1, board.getChampions().indexOf(player1));
        assertEquals("Board - updateChampions 2", 2, board.getChampions().size());

        player3.addPalindrome("wowowow");
        assertEquals("Board - updateChampions 3", 0, board.getChampions().indexOf(player3));
        assertEquals("Board - updateChampions 3", 1, board.getChampions().indexOf(player2));
        assertEquals("Board - updateChampions 3", 2, board.getChampions().indexOf(player1));
        assertEquals("Board - updateChampions 3", 3, board.getChampions().size());

        player4.addPalindrome("wowowowow");
        assertEquals("Board - updateChampions 4", 0, board.getChampions().indexOf(player4));
        assertEquals("Board - updateChampions 4", 1, board.getChampions().indexOf(player3));
        assertEquals("Board - updateChampions 4", 2, board.getChampions().indexOf(player2));
        assertEquals("Board - updateChampions 4", 3, board.getChampions().indexOf(player1));
        assertEquals("Board - updateChampions 4", 4, board.getChampions().size());

        player5.addPalindrome("wowowowowow");
        assertEquals("Board - updateChampions 5", 0, board.getChampions().indexOf(player5));
        assertEquals("Board - updateChampions 5", 1, board.getChampions().indexOf(player4));
        assertEquals("Board - updateChampions 5", 2, board.getChampions().indexOf(player3));
        assertEquals("Board - updateChampions 5", 3, board.getChampions().indexOf(player2));
        assertEquals("Board - updateChampions 5", 4, board.getChampions().indexOf(player1));
        assertEquals("Board - updateChampions 5", 5, board.getChampions().size());

        player6.addPalindrome("wowowowowow");
        assertEquals("Board - updateChampions 6", 0, board.getChampions().indexOf(player5));
        assertEquals("Board - updateChampions 6", 1, board.getChampions().indexOf(player6)); //! player6.score == player5.score and added later
        assertEquals("Board - updateChampions 6", 2, board.getChampions().indexOf(player4));
        assertEquals("Board - updateChampions 6", 3, board.getChampions().indexOf(player3));
        assertEquals("Board - updateChampions 6", 4, board.getChampions().indexOf(player2));
        assertEquals("Board - updateChampions 6", -1, board.getChampions().indexOf(player1));
        assertEquals("Board - updateChampions 6", 5, board.getChampions().size());
    }

    @Test
    public void getRecalculateTest() {
        DaoManager.getDao().removePlayers();
        Player player1 = new Player(1);
        player1.addPalindrome("wow");
        assertEquals("Board - recalculate", 1, board.getChampions().size());
        DaoManager.getDao().removePlayers();
        assertEquals("Board - recalculate", 0, board.getChampions().size());
    }

}
