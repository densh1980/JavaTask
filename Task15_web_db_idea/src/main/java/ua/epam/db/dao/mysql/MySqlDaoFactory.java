package ua.epam.db.dao.mysql;

import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.GenericDao;
import ua.epam.db.entities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Denys_Shmyhin on 10/4/2016.
 */
public class MySqlDaoFactory extends DaoFactory {

    //private static final String DB_CONFIG_FILE_NAME = "db.properties";
    private static final String DB_CONFIG_FILE_NAME = "/db.properties";
    private static final String DB_USER = "db.user";
    private static final String DB_PASS = "db.pass";
    private static final String DB_URL = "db.url";

    private static Connection connection ;

    public MySqlDaoFactory(){
        
    	
    	initConnection();
    }
    private void initConnection(){
        try{
            if( connection == null || connection.isClosed()  ){

                InputStream in = MySqlDaoFactory
                        .class.getResourceAsStream(DB_CONFIG_FILE_NAME);
                Properties props = new Properties();
                props.load(in);
                Class.forName("com.mysql.jdbc.Driver");
                connection =  DriverManager
                        .getConnection( props.getProperty(DB_URL) ,
                                props.getProperty(DB_USER),
                                props.getProperty(DB_PASS));


//                Class.forName("com.mysql.jdbc.Driver");
//                Context envContex = new InitialContext();
//               // Context contex = (Context)envContex.lookup("java:/comp/env/jdbc/usersDB");
//                DataSource dataSource = (DataSource) envContex.lookup("java:/comp/env/jdbc/usersDB");
//                connection = dataSource.getConnection();

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
