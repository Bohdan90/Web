<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Привет +</title>
</head>
<body>
	<FORM action="serv4" method="POST">
		<h2>Input your text:</h2></br>
		
		<%=session.getAttribute("myData")%>

		<textarea rows="5" cols="40" name="get text"></textarea>
		</br> <INPUT type="submit" value="Post message" name="Post" /><br />


	</FORM>
</body>
</html>