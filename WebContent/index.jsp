<%@ page language="java" contentType="text/html; charset=ISO-8859-5"
	pageEncoding="ISO-8859-5"%>

<html>
<title>Login Page</title>
<body>
	<FORM action="serv" method="POST">
		<INPUT type="submit" value="Redirect to other page" name="Take Servlet"> <br/>
		Login: <input type="text" name="user name"><br>
        Passw: <input type="password" name="password"><br> 
        <INPUT type="submit" value="login" name="Take Servlet">
		<INPUT type="submit" value="registr" name="Take Servlet"> <br/>
	</FORM>
</body>
</html>