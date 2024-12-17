package com.example.testpage.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAO {
    private Connection connection;
    public UserDAO(Connection connection){
        this.connection = connection;
    }
    public void insert(User user){
        String insertMessage = "INSERT INTO users(name,email,country) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertMessage)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id){
        String sqlMessage = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(sqlMessage);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void update(User user){
        String sqlMessage = "UPDATE users SET name = ?, email = ?, country = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlMessage);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        String sqlMessage = "SELECT * FROM users";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlMessage);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id,name,email,country);
                users.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return users;
    }
}
