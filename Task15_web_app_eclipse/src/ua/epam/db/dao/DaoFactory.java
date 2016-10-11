package ua.epam.db.dao;


import ua.epam.db.entities.User;

/** Factory for DAO*/

public abstract class  DaoFactory {


    public abstract GenericDao<User> createUserDao();

    public static DaoFactory getInstance(){
        String factoryClassName = "ua.epam.db.dao.mysql.MySqlDaoFactory";
        try {
            return (DaoFactory) Class.forName(factoryClassName)
                    .newInstance();
        } catch (Exception e) {
            //log
            throw new RuntimeException(e);
        }
  }


}
