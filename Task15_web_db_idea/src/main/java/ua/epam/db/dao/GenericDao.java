package ua.epam.db.dao;



import java.sql.SQLException;
import java.util.List;

/**
 * interface  for  DAO
 * @param <T> type of db entities
 */

public interface GenericDao<T> {

    /** close connections after  transaction*/
    public void close() throws PersistException;
    /** create */
    public T create() throws PersistException;

    /** create new db record from obj */
    public T persist(T object)  throws PersistException;

    /** get record by Id */
    public T getById(int id) throws PersistException;

    /** save obj in db */
    public void update(T object) throws PersistException;

    /** delete object from db */
    public void delete(T object) throws PersistException;

    /** get table from db */
    public List<T> getAll() throws PersistException;
}
