package ua.epam.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ua.epam.JndiMock;
import ua.epam.db.dao.DaoFactory;
import ua.epam.db.dao.GenericDao;
import ua.epam.db.dao.mysql.MySqlDaoFactory;
import ua.epam.db.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;


public class AppControllerTest extends Mockito{
    @BeforeClass
    public static void setUpClass() throws Exception {
        //setup the jndi context and the datasource
        // define  test data table
        JndiMock.setupTestJNDI();
    }

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher rd;

    @Mock
    DaoFactory dao;
    @Mock
    GenericDao<User> userDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addNewUserServletTest() throws Exception {

        when(request.getParameter("command")).thenReturn("Add");
        when(request.getRequestDispatcher("/User.jsp")).thenReturn(rd);

        User user = new User();
        AppController app = new AppController();
        app.doGet(request,response);
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(request).setAttribute(eq("user"),argument.capture());
        verify(request).getRequestDispatcher("/User.jsp");
        verify(rd).forward(request,response);
        assertEquals(0,argument.getValue().getId());

    }

    @Test
    public void editUserServletTest() throws Exception {


        when(request.getParameter("command")).thenReturn("Edit");
        when(request.getParameter("userId")).thenReturn("1");
        when(request.getRequestDispatcher("/User.jsp")).thenReturn(rd);

        AppController app = new AppController();
        app.doGet(request,response);

        verify(request).setAttribute(eq("user"),any(User.class));
        verify(request).getRequestDispatcher("/User.jsp");
        verify(rd).forward(request,response);
    }


}
