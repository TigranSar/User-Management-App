<%@ page import="com.example.testpage.model.UserDAO" %>
<%@ page import="com.example.testpage.model.ConnectionDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="mainStyle.css">
</head>
<body>
<header>
    <div class="logo">
        <a href="index.jsp">
            User Management
        </a>
    </div>
    <div class="users">
        <a href="index.jsp">Users</a>
    </div>
</header>
<div class="lister">
    <h1>List of Users</h1>
</div>
<div class="add_user">
    <a href="add_user.jsp">Add New User</a>
</div>
<div class="user_table">
    <table class="whole_table">
        <thead>
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Country</th><th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            UserDAO userDAO = new UserDAO(ConnectionDB.getConnection());
            request.setAttribute("users", userDAO.getAllUsers());
        %>

        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td class="update_links">
                    <a href="edit_data.jsp?id=${user.id}&name=${user.name}&email=${user.email}&country=${user.country}" class="edit_row">Edit</a>
                    <a href="delete_line?id=${user.id}" class="delete_line">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
