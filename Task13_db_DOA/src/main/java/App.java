import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.GenericDao;
import ua.epam.db.dao.PersistException;
import ua.epam.db.entities.User;

import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) throws PersistException{

        // read
        GenericDao<User> dao = DaoFactory.getInstance().createUserDao();
        List<User> user = dao.getAll();

            //user.forEach(u -> System.out.println(u));

        // update
        User forUpdate = user.get(5);
        forUpdate.setEmail("old"+getRndChar()+"@email.net");
        forUpdate.setFirstName("Jonny"+ getRndChar() );

        dao.update(forUpdate);

            //user = dao.getAll();
            //user.forEach(u -> System.out.println(u));

        // read by Id
         User singleUser = dao.getById(6);
        System.out.println(singleUser);


         // create
        User newUser = dao.persist(singleUser);

        // delete
        dao.delete(newUser);


    }

    private static char getRndChar() {
        Random rnd =  new Random();
        return (char) ('a'+ rnd.nextInt('z'-'a'));
    }

}
