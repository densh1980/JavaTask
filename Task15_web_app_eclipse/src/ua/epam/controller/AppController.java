package ua.epam.controller;

import java.io.IOException;
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

		int action = checkAction(request);

		switch (action) {

		//list of all users
		case 0:
			try {

				GenericDao<User> userDao = DaoFactory.getInstance().createUserDao();
				List<User> users = userDao.getAll();

				request.setAttribute("users", users);
				getServletContext().getRequestDispatcher("/UsersList.jsp").forward(request, response);


			} catch (PersistException e) {
				e.printStackTrace();
			}
			break;

			// redirect to add
		case 1:	

			User user = new User();
			request.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);

			break;

			// redirect to edit 
		case 2:	

			try {

				user = DaoFactory.getInstance().createUserDao().
						getById( Integer.valueOf(request.getParameter("userId")) );
				request.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);				

			} catch (PersistException | NumberFormatException e) {
				e.printStackTrace();
			}			
			break;

			//redirect to users after update or add
		case 3:
			response.sendRedirect("./users");
			break;

		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private int checkAction(HttpServletRequest request) {

		String command = request.getParameter("command");
		if(command == null) return 0;
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
				try {
					DaoFactory.getInstance().createUserDao().delete(s);
				} catch (PersistException e) {

					e.printStackTrace();
				};
			}
			return 0;
		}
		if(command.equals("Save")){

			User user = extractUserFromRequest(request);

			if (user.getId() == 0){
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

			return 3;
		}
		return 0;
	}

	private User extractUserFromRequest(HttpServletRequest request) {
		User  user =new User();
		user.setId(Integer.valueOf(request.getParameter("userId")));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		return user;
	}

}
