package org.palindrome.core.dao;

import org.palindrome.core.domain.Board;

/**
 * Created by andrewavetisov on 02.04.16.
 */
public class DaoManager {

    private static IDao instance = null;

    /**
     * Dao's concurrent singletone.
     * @return instance of a dao.
     */
    public static synchronized IDao getDao() {
        if (instance == null)
            instance = new InMemoryDao();
        return instance;
    }
}
