package org.palindrome.core.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewavetisov on 02.04.16.
 */
public class DaoTest {
    private IDao dao;

    @Before
    public void setup() throws NoSuchFieldException {
        dao = DaoManager.getDao();
        //clean context
        dao.removePlayers();
    }

    @Test
    public void daoMethodesTest() {
        assertEquals("Dao - getPlayers 0", 0, dao.getPlayers().size());
        dao.getOrCreatePlayer(1);
        dao.getOrCreatePlayer(1);
        dao.getOrCreatePlayer(2);
        assertEquals("Dao - getPlayers 2", 2, dao.getPlayers().size());
        dao.removePlayers();
        assertEquals("Dao - getPlayers 0", 0, dao.getPlayers().size());
    }
}
