package ForumContr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import BDconnectToForum.ConnectFoForum;

@SuppressWarnings("serial")
@WebServlet(name = "serv4", urlPatterns = "/serv4")
public class ForumSrvlt extends HttpServlet {

	private String text;
	private int index;
	private String rextHuext;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ConnectFoForum connectDB = new ConnectFoForum();

		String buttonPressed = request.getParameter("Post");// получаем
															// введенный текст

		HttpSession session = request.getSession(true);

		if (buttonPressed.equals("Post message")) {
			rextHuext = null;
			text = request.getParameter("get text");
			connectDB.addText(text);
			HashMap<Integer, String> getForumMess = connectDB.getText();

			for (Entry<Integer, String> entry : getForumMess.entrySet()) {
				// System.out.println("ID =  " + entry.getKey() + " ЗНАЧЕНИЕ = "
				// + entry.getValue());
				rextHuext = rextHuext + entry.getValue() + "<br/>" ;

			}
			session.setAttribute("myData", rextHuext);
			response.sendRedirect(request.getContextPath() + "/forum.jsp");

		}

	}
}
