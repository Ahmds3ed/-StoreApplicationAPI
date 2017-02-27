<%-- 
    Document   : login
    Created on : Feb 27, 2017, 3:29:15 PM
    Author     : lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/login"  method="post" >
            <table align="center" >
                <tr>
                    <td>Username </td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="login" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>
