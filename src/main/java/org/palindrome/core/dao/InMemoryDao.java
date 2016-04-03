package org.palindrome.core.dao;

import org.palindrome.core.domain.Board;
import org.palindrome.core.domain.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrewavetisov on 01.04.16.
 */
public class InMemoryDao implements IDao {

    private static final Map<Integer, Player> playerMap = new HashMap<>();

    InMemoryDao() {
    }

    @Override
    public Player getOrCreatePlayer(int id) {
        synchronized (playerMap) {
            if (playerMap.containsKey(id)) {
                return playerMap.get(id);
            } else {
                Player player = new Player(id);
                playerMap.put(id, player);
                return player;
            }
        }
    }

    @Override
    public List<Player> getPlayers() {
        synchronized (playerMap) {
            return new ArrayList<>(playerMap.values());
        }
    }

    @Override
    public void removePlayers() {
        synchronized (playerMap) {
            playerMap.clear();
            Board.getInstance().recalculate();
        }
    }


}
