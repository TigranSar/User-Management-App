package com.example.testpage.controller;

import com.example.testpage.model.ConnectionDB;
import com.example.testpage.model.User;
import com.example.testpage.model.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EditDataServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);
        UserDAO userDAO = new UserDAO(ConnectionDB.getConnection());
        userDAO.update(user);
        resp.sendRedirect("index.jsp");
    }
}
