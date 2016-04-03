package RegistrContr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BDconnectToUsers.SQLconnect;

@SuppressWarnings("serial")
@WebServlet(name = "serv2", urlPatterns = "/serv2")
public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SQLconnect sqlCon = new SQLconnect();
		String buttonPressed = request.getParameter("Take Servlet");
		if (buttonPressed.equals("registration")) {
			String nameOfUser = request.getParameter("your name");
			String userAge = request.getParameter("your age");
			System.out.println(nameOfUser);
			System.out.println(userAge);
			int age = Integer.parseInt(userAge);
			sqlCon.addUser(age, nameOfUser);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}
