package ua.epam.db.dao;


import org.apache.log4j.Logger;
import ua.epam.controller.AppController;
import ua.epam.db.entities.User;

import java.sql.Connection;

/** Factory for DAO*/

public abstract class  DaoFactory {
    private static final Logger log = Logger.getLogger(AppController.class);

    public abstract GenericDao<User> createUserDao();

    public static DaoFactory getInstance() throws PersistException {
        String factoryClassName = "ua.epam.db.dao.mysql.MySqlDaoFactory";
        try {
            return (DaoFactory) Class.forName(factoryClassName)
                    .newInstance();
        } catch (Exception e) {
           log.error("Can't create instance of MySqlDaoFactory ",e);
            throw new PersistException(e);
        }
    }

    public abstract  Connection getConnection();


}
