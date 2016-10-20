package ua.epam;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Denys_Shmyhin on 10/19/2016.
 */
public class JndiMock {
    public static void setupTestJNDI() {
        try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                    "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES,
                    "org.apache.naming");
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:/comp");
            ic.createSubcontext("java:/comp/env");
            ic.createSubcontext("java:/comp/env/jdbc");

            // Construct DataSource
            MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
            ds.setURL("jdbc:mysql://localhost:3306/users_test_db");
            ds.setUser("root");
            ds.setPassword("atoll+");

            ic.bind("java:/comp/env/jdbc/usersDB", ds);
        } catch (NamingException ex) {

        }
    }
}
