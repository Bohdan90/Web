package MainPageContr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import BDconnectToUsers.SQLconnect;

@SuppressWarnings("serial")
@WebServlet(name = "serv", urlPatterns = "/serv")
public class ContServlet extends HttpServlet {

	private String urlRBK = ("https://rbkmoney.ru/acceptpurchase.aspx");
	private SQLconnect sqlCon = new SQLconnect();
	private HashMap<String, String> userList = sqlCon.getUser();

	private String nameOfUser;
	private String userAge;
	private boolean checkLoginValidation = false;

	private void checkLogin() {
		if (userAge != ("") && nameOfUser != ("")) {
			if (userList.containsKey(nameOfUser)) {
				if (userList.get(nameOfUser).equals(userAge)) {
					checkLoginValidation = true;
				} else {
					System.out.println("incorrect password");
				}
			} else {
				System.out.println("not exist user");
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		nameOfUser = request.getParameter("user name"); // данные логин
		userAge = request.getParameter("password"); // данные пароль

		checkLogin();
		System.out.println(checkLoginValidation);
		String buttonPressed = request.getParameter("Take Servlet");
		if (buttonPressed.equals("Redirect to other page")) {
			response.sendRedirect(urlRBK);
		} else if (buttonPressed.equals("registr")) {
			response.sendRedirect(request.getContextPath() + "/regist.jsp");
		} else if (buttonPressed.equals("login")
				&& checkLoginValidation == true) {
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		} else {
			response.sendRedirect(urlRBK);
		}
	}
}