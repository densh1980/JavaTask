package ua.epam.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.GenericDao;
import ua.epam.db.dao.PersistException;
import ua.epam.db.entities.User;

/**
 * Servlet implementation class App Controller
 */

@WebServlet("/users")
public class AppController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public AppController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text / html;charset=UTF-8");

        int action = checkAction(request, response);

        switch (action) {

            //list of all users
            case 0:

                showUsersList(request, response);
                break;

            // redirect to add
            case 1:

                showAddUserPage(request, response);
                break;

            // redirect to edit
            case 2:
                showEditUserPage(request, response);
                break;
            //redirect to users after update or add
            case 3:
                response.sendRedirect("./users");
                break;

            case 4:
                try {
                    GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
                    Map map = request.getParameterMap();
                    Map <String,String>  params = new HashMap<String,String>();
                    for (Object key: map.keySet())
                    {
                        String keyStr = (String)key;
                        String value = ((String[]) map.get(keyStr))[0];
                       params.put(keyStr,value);
                    }

                    List<User> users = userDao.getBy(params);
                    userDao.close();
                    request.setAttribute("users", users);
                    getServletContext().getRequestDispatcher("/UsersList.jsp").forward(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;

            default:
                break;
        }

    }

    private void showEditUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            User user = DaoFactory.getInstance().createUserDao()
                    .getById(Integer.valueOf(request.getParameter("userId")));
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);

        } catch (PersistException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void showAddUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        request.setAttribute("user", user);
        //getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
        request.getRequestDispatcher("/User.jsp").forward(request, response);
    }

    private void showUsersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
            List<User> users = userDao.getAll();
            userDao.close();


            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/UsersList.jsp").forward(request, response);


        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private int checkAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter("command");
        if (command == null) return 0;
        if (command.equals("Add")) {
            return 1;
        }
        if (command.equals("Edit")) {
            return 2;
        }
        if (command.equals("Delete")) {
            if (request.getParameter("userId") != null) {
                User s = new User();
                s.setId(Integer.parseInt(request.getParameter("userId")));
                deleteUser(s);
            }
            return 0;
        }
        if (command.equals("Save")) {

            User user = extractUserFromRequest(request);
            if (!validateUserBeforeSave(user, request)) {
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
                return -1;
            }
            saveUser(user);
            return 3;
        }

        if (command.equals("Filter")) {
            return 4;
        }
        return 0;
    }

    private boolean validateUserBeforeSave(User user, HttpServletRequest request) {
        final String NAME_PATTERN = "^[\\p{L} -']{1,40}\\z";
        final String PHONE_PATTERN = "^(\\+\\d{1,3}[- ]?)?[\\d -]{6,13}$|\\z";
        final String EMAIL_PATTERN = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}\\b";
//tut  nested class

        boolean res = true;
        UserInputAlert alert = new UserInputAlert();

        if (!user.getFirstName().matches(NAME_PATTERN)) {
            alert.setMessage("First name is wrong");
            alert.toggleFieldToAlert(0);
            res = false;
        }

        if (!user.getLastName().matches(NAME_PATTERN)) {
            alert.setMessage("Last name is wrong");
            alert.toggleFieldToAlert(1);
            res = false;
        }
        if (!user.getPhone().matches(PHONE_PATTERN)) {
            alert.setMessage("Phone  number is wrong");
            alert.toggleFieldToAlert(2);
            res = false;
        }
        if (!user.getEmail().matches(EMAIL_PATTERN)) {
            alert.setMessage("Email is wrong");
            alert.toggleFieldToAlert(3);
            res = false;
        }

        request.setAttribute("alert", alert);

        return res;
    }


    private void deleteUser(User s) {
        try {
            DaoFactory.getInstance().createUserDao().delete(s);
        } catch (PersistException e) {

            e.printStackTrace();
        }
        ;
    }

    private void saveUser(User user) {
        if (user.getId() == 0) {
            //new
            try {
                DaoFactory.getInstance().createUserDao().persist(user);
            } catch (PersistException e) {

                e.printStackTrace();
            }

        } else {
            //update
            try {
                DaoFactory.getInstance().createUserDao().update(user);
            } catch (PersistException e) {

                e.printStackTrace();
            }
        }
    }

    private User extractUserFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("userId")));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        return user;
    }


}

