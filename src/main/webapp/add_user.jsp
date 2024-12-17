<%--
  Created by IntelliJ IDEA.
  User: benja
  Date: 12/12/2024
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="mainStyle.css">
    <link rel="stylesheet" href="add_user_style.css">
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
<div class="add_user">
    <div class="add_user_text">
        <p id="add_text">Add New User</p>
    </div>
    <form method="POST" action="add_user">
        <input type="text" name="name" id="name_id" placeholder="Enter your name" minlength="1" maxlength="80"><br>
        <input type="email" name="email" id="email_id" placeholder="Enter your email" maxlength="80"><br>
        <select id="country_id" name="country">
            <option value="" disabled selected>Select your country</option>
            <option value="Armenia">Armenia</option>
            <option value="Italy">Italy</option>
            <option value="Iceland">Iceland</option>
            <option value="Algeria">Algeria</option>
            <option value="Argentina">Argentina</option>
            <option value="Canada">Canada</option>
            <option value="Turkey">Turkey</option>
            <option value="Greece">Greece</option>
            <option value="Antarctica">Antarctica</option>
            <option value="Antigua and Barbuda">Antigua and Barbuda</option>
            <option value="Argentina">Argentina</option>
            <option value="United States">United States</option>
            <option value="Aruba">Aruba</option>
            <option value="Australia">Australia</option>
            <option value="Austria">Austria</option>
            <option value="Russia">Russia</option>
            <option value="China">China</option>
            <option value="Japan">Japan</option>
            <option value="Germany">Germany</option>
            <option value="Brazil">Brazil</option>
        </select><br>
        <input type="submit" value="Save" id="save_id">
    </form>
</div>
</body>
</html>
