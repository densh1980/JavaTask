package ua.epam.db.dao.mysql;


import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.junit.*;
import ua.epam.JndiMock;
import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.PersistException;
import ua.epam.db.entities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.hamcrest.Matchers.*;

/**
 * Created by Denys_Shmyhin on 10/19/2016.
 */
public class MySqlUserDaoTest {
    DaoFactory daoFactory = new MySqlDaoFactory();
    Connection connection;


    @BeforeClass
    public static void setUpClass() throws Exception {
        //setup the jndi context and the datasource
        // define  test data table
        JndiMock.setupTestJNDI();
    }

    @Before
    public void setUp() throws PersistException {

        try {
            connection = daoFactory.getConnection();
            connection.setAutoCommit(false);

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @After
    public void tearDown() throws PersistException {

        try {
            connection.rollback();
            connection.close();

        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }


    @Test
    public void addNewUserTestPos() throws PersistException, SQLException {

        User expected = new User();
        expected.setFirstName("SomeNewUser");

        User actual = DaoFactory.getInstance().createUserDao().persist(expected);
        Assert.assertThat(expected.getFirstName(),is(actual.getFirstName()));
    }
    @Test
    public void addNewUserTestNeg() throws PersistException, SQLException {

        User expected = new User();
        expected.setFirstName("SomeNewUserExistingId");
        expected.setId(1);
        User actual = DaoFactory.getInstance().createUserDao().persist(expected);
        Assert.assertThat(expected.getFirstName(),is(actual.getFirstName()));
        Assert.assertThat(expected.getId(),is(not(actual.getId())));
    }
    @Test
    public void findByIdTestPos() throws PersistException, SQLException {

        User expected = new User();
            expected.setId(1);
            expected.setFirstName("Мария");
            expected.setLastName("Шепель");
            expected.setPhone("333-22-11");
            expected.setEmail("asd@com");

        User actual = DaoFactory.getInstance().createUserDao().getById(1);
        Assert.assertThat(expected,is(actual));
    }

    @Test(expected = PersistException.class)
    public void findByNotExistingIdNeg() throws PersistException, SQLException {

        User expected = new User();
        expected.setId(10);

        User actual = DaoFactory.getInstance().createUserDao().getById(10);

    }

    @Test
    public void findByMapTestPos() throws PersistException {
        Map<String,String> findKeyVal= new HashMap<>();
            findKeyVal.put("firstName","Иван");
            findKeyVal.put("lastName","");
            findKeyVal.put("phone","");
            findKeyVal.put("email","");

        List<User> actual = DaoFactory.getInstance().createUserDao().getBy(findKeyVal);

        Assert.assertThat(actual.size(),is(2));
    }

    @Test
    public void findByMapTestNeg() throws PersistException {
        Map<String,String> findKeyVal= new HashMap<>();
            findKeyVal.put("firstName","");
            findKeyVal.put("lastName","");
            findKeyVal.put("phone","322-22-3");
            findKeyVal.put("email","");

        List<User> actual = DaoFactory.getInstance().createUserDao().getBy(findKeyVal);
        Assert.assertThat(actual.size(),is(0));
    }

    @Test
    public void updateUserTestPos() throws PersistException, SQLException {

        User expected = new User();
        expected.setId(1);
        expected.setFirstName("Маша");
        expected.setLastName("Иванова");
        expected.setPhone("77-22-11");
        expected.setEmail("asd@com.ua");

        DaoFactory.getInstance().createUserDao().update(expected);
        User actual = DaoFactory.getInstance().createUserDao().getById(1);
        Assert.assertThat(expected,is(actual));
    }

    @Test
    public void deleteUserTestPos() throws PersistException, SQLException {

        User expected = new User();
        expected.setId(1);
        expected.setFirstName("Маша");
        expected.setLastName("Иванова");
        expected.setPhone("77-22-11");
        expected.setEmail("asd@com.ua");

        DaoFactory.getInstance().createUserDao().delete(expected);
        List<User> actual = DaoFactory.getInstance().createUserDao().getAll();
        Assert.assertThat(actual.size(), is(5));
    }
    @Test(expected = PersistException.class)
    public void deleteUserTestNeg() throws PersistException, SQLException {

        User expected = new User();
        expected.setId(100);
        expected.setFirstName("Маша");
        expected.setLastName("Иванова");
        expected.setPhone("77-22-11");
        expected.setEmail("asd@com.ua");

        DaoFactory.getInstance().createUserDao().delete(expected);
    }

    @Test
    public void getAllUsersTestPos() throws PersistException, SQLException {


        List<User> actual = DaoFactory.getInstance().createUserDao().getAll();
        Assert.assertThat(actual.size(), is(6));
    }




}