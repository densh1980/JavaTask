package ua.epam.db;

import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.GenericDao;
import ua.epam.db.dao.PersistException;
import ua.epam.db.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Андрей on 18.10.2016.
 */
public class AppCons {
    public static void main(String[] args) {
        GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
        Map<String,String> params = new HashMap<String,String>();
        params.put("firstName","densh");
        try {
            List<User> users = userDao.getBy(params);
            System.out.println(users);


        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
