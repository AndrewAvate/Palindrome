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

    public static synchronized GameFacade getInstance() {
        if (instance == null)
            instance = new GameFacade();
        return instance;
    }

    public void addWord(int playerID, String word) {
        Player player = dao.getOrCreatePlayer(playerID);
        player.addPalindrome(word);
    }

    public List<Player> getChampionsTable() {
            return board.getChampions();

    }



}
