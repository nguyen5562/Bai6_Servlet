<%--
  Created by IntelliJ IDEA.
  User: Nguyen Khoi Nguyen
  Date: 2/29/2024
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
</head>
<body>
    <h1>Add New Book</h1>
    <form action="create-book" method="post">
    <table>
    <tr><td>ID:</td><td><input type="text" name="id"/></td></tr>
    <tr><td>Mô tả chi tiết:</td><td><input type="text" name="longDescription"/></td></tr>
    <tr><td>Mô tả tóm tắt:</td><td><input type="text" name="shortDescription"/></td></tr>
    <tr><td>Giá:</td><td><input type="number" name="cost"/></td></tr>

    <tr><td colspan="2"><input type="submit" value="Save book"/></td></tr>
    </table>
    </form>

    <br/>
    <a href="view-books">View books</a>
</body>
</html>
