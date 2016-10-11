package ua.epam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ManagmentSysytem
 */

@WebServlet("/user")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text / html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<B> Список пользователей </B>");
        pw.println("<table border = 1>");
        try {
            
        	GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
        	List<User> users = userDao.getAll();
        	
        	for (User user : users) {
				pw.println("<tr>");
				pw.println("<td>" + user.getFirstName() + "</td>");
				pw.println("<td>" + user.getLastName() + "</td>");
				pw.println("<td>" + user.getPhone() + "</td>");
				pw.println("<td>" + user.getEmail() + "</td>");
        		pw.println("</tr>");
			}
       	

        } catch (PersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        pw.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
