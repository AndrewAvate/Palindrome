package org.palindrome.core.domain;

import org.palindrome.core.dao.DaoManager;
import org.palindrome.core.dao.IDao;

import java.util.*;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class Board {

    private static final int SIZE = 5;

    private List<Player> champions;
    private static Board instance = null;
    private IDao dao;

    private Board() {
        this.champions = new ArrayList<>();
        dao = DaoManager.getDao();
    }

    /**
     * Concurrent Board Singleton.
     * @return instance of the Board
     */
    public static synchronized Board getInstance() {
        if (instance == null)
            instance = new Board();
        return instance;
    }

    synchronized void updateChampions(Player player) {
        if (!champions.contains(player)) {
            champions.add(player);
        }

        Collections.sort(champions, (o1, o2) -> {
            return Integer.compare(o2.getScore(), o1.getScore()); //First, the player with the higher score
        });

        if (champions.size() > SIZE) {
            champions = champions.subList(0, SIZE);
        }
    }

    /**
     *
     * @return game's champion list (5 elements), orderd by score.
     */
    public synchronized List<Player> getChampions() {
        return new ArrayList<>(champions);
    }

    /**
     * recalculates the list of Champions,
     * taking into account all the players.
     */
    public synchronized void recalculate() {
        champions = dao.getPlayers();
        Collections.sort(champions, (o1, o2) -> {
            return Integer.compare(o2.getScore(), o1.getScore()); //First, the player with the higher score
        });

        if (champions.size() > SIZE) {
            champions = champions.subList(0, SIZE);
        }
    }

}
