package ua.epam.db.dao.mysql;

import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.GenericDao;
import ua.epam.db.entities.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Denys_Shmyhin on 10/4/2016.
 */
public class MySqlDaoFactory extends DaoFactory {

    private static final String DB_CONFIG_FILE_NAME = "db.properties";
    private static final String DB_USER = "db.user";
    private static final String DB_PASS = "db.pass";
    private static final String DB_URL = "db.url";

    private static Connection connection ;

    public MySqlDaoFactory(){
        
    	
    	initConnection();
    }
    private void initConnection(){
        try{
            if( connection == null ){
                InputStream in = MySqlDaoFactory
                        .class.getResourceAsStream(DB_CONFIG_FILE_NAME);
                Properties props = new Properties();
                props.load(in);
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection =  DriverManager
                        .getConnection( props.getProperty(DB_URL) ,
                                props.getProperty(DB_USER),
                                props.getProperty(DB_PASS));
            }
            return;
        }catch(Exception ex){
            // add logging
            throw new RuntimeException( ex );
        }

    }



    @Override
    public GenericDao<User> createUserDao() {
        return  new MySqlUserDao(connection);
    }
}
