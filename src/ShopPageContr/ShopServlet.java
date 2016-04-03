package ShopPageContr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "serv3", urlPatterns = "/serv3")
public class ShopServlet extends HttpServlet {
	private String urlRBK = ("https://rbkmoney.ru/acceptpurchase.aspx");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String buttonPressed = request.getParameter("Take Servlet");
		if (buttonPressed.equals("Redirect to back Page")) {
			System.out.println("TUT RABOTAET SERV3");
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		} else if (buttonPressed.equals("Discuss on Forum")) {
			System.out.println("IDEM NA FORUM");
			response.sendRedirect(request.getContextPath() + "/forum.jsp");
		} else {
			System.out.println("IDEM NA RBKMONEY PAGE");
			response.sendRedirect(urlRBK);
		}
	}
}
