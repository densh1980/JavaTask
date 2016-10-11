

package ua.epam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Calculator")

public class Calculator extends	 HttpServlet{
	
	/**
	 * 		
	 */
	private static final long serialVersionUID = 1L;
	private static final String FIRST_PARAM ="firstParam";
	private static final String SECOND_PARAM ="secondParam";

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String firstParameter =request.getParameter(FIRST_PARAM);
		String secondParameter =request.getParameter(SECOND_PARAM);
		int firstValue = 0;
		int secondValue = 0;
		try{
			firstValue = Integer.parseInt(firstParameter);
			secondValue = Integer.parseInt(secondParameter);
		} catch(NumberFormatException ex){
			
			out.print("Error " + ex.getMessage());
			return;
		}
		int result =firstValue + secondValue;
		out.print(firstParameter + "+" +secondParameter + "=" +result);
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		super.doPost(request, response);
	}
}


