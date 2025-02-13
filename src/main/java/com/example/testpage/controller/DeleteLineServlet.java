package com.example.testpage.controller;

import com.example.testpage.model.ConnectionDB;
import com.example.testpage.model.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteLineServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO(ConnectionDB.getConnection());
        userDAO.delete(id);
        resp.sendRedirect("index.jsp");
    }
}
