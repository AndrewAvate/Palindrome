package org.palindrome.core.dao;

import org.palindrome.core.domain.Player;

import java.util.List;

/**
 * Created by andrewavetisov on 02.04.16.
 */
public interface IDao {
    /**
     * find or create player by id
     * @param id player id
     * @return instance of Player
     */
    Player getOrCreatePlayer(int id);

    /**
     * Full list of players
     * @return List <Player>
     */
    List<Player> getPlayers();

    /**
     * remove all players
     */
    void removePlayers();
}
