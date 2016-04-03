package org.palindrome.core;

import org.junit.Before;
import org.junit.Test;
import org.palindrome.core.dao.DaoManager;
import org.palindrome.core.domain.Board;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewavetisov on 02.04.16.
 */
public class GameFacadeTest {

    private GameFacade game;

    @Before
    public void setup() {
        game = GameFacade.getInstance();
        //clean context
        DaoManager.getDao().removePlayers();
    }

    @Test
    public void getInstanceTest() {
        assertEquals("GameFacade - constructor", GameFacade.getInstance(), game);
    }

    @Test
    public void gameTest() {

        game.addWord(1, "wow");
        assertEquals("Game - addWord 1", 1, game.getChampionsTable().size());
        assertEquals("Game - addWord 1", 3, game.getChampionsTable().get(0).getScore());
        assertEquals("Game - addWord 1", 1, game.getChampionsTable().get(0).getId());

        game.addWord(1, "lol lol");
        assertEquals("Game - addWord 1", 1, game.getChampionsTable().size());
        assertEquals("Game - addWord 1", 10, game.getChampionsTable().get(0).getScore());
        assertEquals("Game - addWord 1", 1, game.getChampionsTable().get(0).getId());

        game.addWord(1, "lol lol");
        assertEquals("Game - addWord 1", 1, game.getChampionsTable().size());
        assertEquals("Game - addWord 1", 10, game.getChampionsTable().get(0).getScore());
        assertEquals("Game - addWord 1", 1, game.getChampionsTable().get(0).getId());

        game.addWord(2, "wow");
        assertEquals("Game - addWord 2", 2, game.getChampionsTable().size());
        assertEquals("Game - addWord 2", 3, game.getChampionsTable().get(1).getScore());
        assertEquals("Game - addWord 2", 2, game.getChampionsTable().get(1).getId());

        game.addWord(3, null);
        assertEquals("Game - addWord 3", 2, game.getChampionsTable().size());
        assertEquals("Game - addWord 3", -1, game.getChampionsTable().indexOf(3));

        game.addWord(3, "");
        assertEquals("Game - addWord 3", 2, game.getChampionsTable().size());
        assertEquals("Game - addWord 3", -1, game.getChampionsTable().indexOf(3));

        assertEquals("Game - addWord 3", Boolean.TRUE, game.addWord(3, "wowowowowow"));
        assertEquals("Game - addWord 3", Boolean.FALSE, game.addWord(3, "wowowowowow"));
        assertEquals("Game - addWord 3", Boolean.FALSE, game.addWord(3, "wo"));
        assertEquals("Game - addWord 3", 3, game.getChampionsTable().size());
        assertEquals("Game - addWord 3", 11, game.getChampionsTable().get(0).getScore());
        assertEquals("Game - addWord 3", 3, game.getChampionsTable().get(0).getId());
    }
}
