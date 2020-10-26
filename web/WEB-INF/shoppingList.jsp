<%-- 
    Document   : shoppingList
    Created on : Oct 21, 2020, 3:13:46 PM
    Author     : BTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>
        
        <form method="post" action="ShoppingList">
        <table>
            <tr><td>Add Item: </td><td><input type="text" name="item" value="${item}"></td>
            <td><input type="submit" value="Add"><input type="hidden" name="action" value="add"></td></tr>
        </table>
        </form>
        
        <form method="post" action="ShoppingList"> 
            <ul>
                <c:forEach var="items" items="${items}">
                    <li><input type="radio" name="itemList" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
