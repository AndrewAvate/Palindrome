package org.palindrome.core.dao;

import org.palindrome.core.domain.Player;

import java.util.List;

/**
 * Created by andrewavetisov on 02.04.16.
 */
public interface IDao {
    Player getOrCreatePlayer(int id);
    List<Player> getPlayers();
    void removePlayers();
}
