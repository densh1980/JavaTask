package ua.epam.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
    private static final Logger log = Logger.getLogger(AppController.class);
    public static final String SYMBOL = "(\\%+|'+|\"+|\\\\|_+|\\[+|\\]+|=+)";


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
                log.debug("call redirect /users " + getRequestAsString(request));
                response.sendRedirect("./users");
                break;

            // filter users
            case 4:
                showFilteredUsersList(request, response);
                break;

            default:
                break;
        }

    }

    private String getRequestAsString(HttpServletRequest request) {
        Map params = request.getParameterMap();
        StringBuilder res = new StringBuilder("Request: ");
        Iterator i = params.keySet().iterator();
        while (i.hasNext()) {
            String key = (String) i.next();
            res.append(key);
            res.append("=");
            String value = ((String[]) params.get(key))[0];
            res.append(value);
            res.append(" ");
        }
        return res.toString();
    }

    private void showFilteredUsersList(HttpServletRequest request, HttpServletResponse response) {

        log.debug("call showFilteredUsersList " + getRequestAsString(request));

        try {
            GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
            Map<String, String> params = getRequestParamsAsStrStrMap(request);
            List<User> users = userDao.getBy(params);
            userDao.close();
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/UsersList.jsp").forward(request, response);

        } catch (Exception e) {
            log.error("failed!", e);
        }
    }

    private Map<String, String> getRequestParamsAsStrStrMap(HttpServletRequest request) {
        Map map = request.getParameterMap();
        Map<String, String> params = new HashMap<String, String>();
        for (Object key : map.keySet()) {
            String keyStr = (String) key;
            String value = ((String[]) map.get(keyStr))[0];

            //remove illegal characters from request
            //replace *  wildcard  char
            value = value.replaceAll(SYMBOL, "");
            // OR "" REP "%" ? to do
            value = value.replaceAll("\\*+","%");
            params.put(keyStr, value);
        }
        return params;
    }

    private void showEditUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("call showEditUserPage" + getRequestAsString(request));

        try {
            User user = DaoFactory.getInstance().createUserDao()
                    .getById(Integer.valueOf(request.getParameter("userId")));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/User.jsp").forward(request, response);
        //    getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);

        } catch (PersistException | NumberFormatException e) {
            log.error("failed to get user by id !", e);
        }
    }

    private void showAddUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("call showAddUserPage" + getRequestAsString(request));

        User user = new User();
        request.setAttribute("user", user);
        //getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
        request.getRequestDispatcher("/User.jsp").forward(request, response);
    }

    private void showUsersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            log.debug("call showUsersList" + getRequestAsString(request));

            GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
            List<User> users = userDao.getAll();
            userDao.close();

            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/UsersList.jsp").forward(request, response);


        } catch (PersistException e) {
            log.error("failed to get list of users!", e);
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
            if (request.getParameter("userId") == null) return 1;
            return 2;
        }
        if (command.equals("Delete")) {
            if (request.getParameter("userId") != null) {
                User s = new User();
                s.setId(Integer.parseInt(request.getParameter("userId")));
                log.debug("Delete users " + getRequestAsString(request));
                deleteUser(s);
            }
            return 0;
        }
        if (command.equals("Save")) {

            log.debug("try  to save User" + getRequestAsString(request));

            User user = extractUserFromRequest(request);
            if (!validateUserBeforeSave(user, request)) {
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);

                log.debug("User not valid -> go to the next try" + getRequestAsString(request));
                return -1;
            }

            log.debug("call saveUser" + getRequestAsString(request));
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
            log.error("failed  to delete user!", e);
        }
        ;
    }

    private void saveUser(User user) {
        if (user.getId() == 0) {
            //new
            try {
                DaoFactory.getInstance().createUserDao().persist(user);
            } catch (PersistException e) {
                log.error("failed to create new user!", e);
            }

        } else {
            //update
            try {
                DaoFactory.getInstance().createUserDao().update(user);
            } catch (PersistException e) {
                log.error("failed  to update user!", e);
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

