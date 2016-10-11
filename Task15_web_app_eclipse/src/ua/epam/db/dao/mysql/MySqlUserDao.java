package ua.epam.db.dao.mysql;

import ua.epam.db.dao.AbstractJDBCDao;
import ua.epam.db.dao.PersistException;
import ua.epam.db.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denys_Shmyhin on 10/4/2016.
 */

public class MySqlUserDao extends AbstractJDBCDao<User> {


    public MySqlUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public User create() throws PersistException {
        User g = new User();
        return persist(g);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, first_name, last_name, phone, email FROM  users";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (first_name, last_name, phone, email) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE users SET first_name= ?, last_name = ?, phone = ?, email = ?  WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM users WHERE id= ?;";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<User> result = new LinkedList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                result.add(user);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(1,object.getFirstName());
            statement.setString(2,object.getLastName());
            statement.setString(3,object.getPhone());
            statement.setString(4,object.getEmail());
        } catch (SQLException e) {
            throw  new PersistException(e);
        }

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(1,object.getFirstName());
            statement.setString(2,object.getLastName());
            statement.setString(3,object.getPhone());
            statement.setString(4,object.getEmail());
            statement.setInt(5,object.getId());
        } catch (SQLException e) {
            throw  new PersistException(e);
        }
    }
}
