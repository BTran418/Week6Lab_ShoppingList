<%-- 
    Document   : register.jsp
    Created on : Oct 21, 2020, 3:13:34 PM
    Author     : BTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="" method="post"><table>
            <tr><td>Username: <input type="text" name="username" value="${username}"></td></tr>
            <tr><td><input type="submit" value="Register Name"><input type="hidden" name="action" value="register"></td></tr>
        </table></form>
        ${message}
    </body>
</html>
