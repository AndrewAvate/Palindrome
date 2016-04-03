package org.palindrome.core;

import org.palindrome.core.dao.DaoManager;
import org.palindrome.core.dao.IDao;
import org.palindrome.core.domain.Board;
import org.palindrome.core.domain.Player;

import java.util.List;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class GameFacade {

    private static GameFacade instance;
    private static IDao dao;
    private static Board board;

    private GameFacade() {
        dao = DaoManager.getDao();
        board = Board.getInstance();

    }

    /**
     * Concurrent GameFacade Singleton.
     * @return instance of the GameFacade
     */
    public static synchronized GameFacade getInstance() {
        if (instance == null)
            instance = new GameFacade();
        return instance;
    }

    /**
     * Add word to player's word-set.
     *
     * @param playerID player id
     * @param word word
     * @return true - new palindrome, false - not a palindorme or already exist in a player's word-set.
     */
    public boolean addWord(int playerID, String word) {
        Player player = dao.getOrCreatePlayer(playerID);
        return player.addPalindrome(word);
    }

    /**
     * @return game's champion list (5 elements), orderd by score.
     */
    public List<Player> getChampionsTable() {
            return board.getChampions();
    }



}
