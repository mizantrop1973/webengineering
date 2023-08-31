package com.java.webengineering.dao.impl;

import com.java.webengineering.dao.UserDAO;
import com.java.webengineering.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class JdbcApiUserDAO implements UserDAO {
    private static Connection conn;

    static {
        String url = null;
        String username = null;
        String password = null;

        try (InputStream in = UserDAO.class.getClassLoader().getResourceAsStream("persistence.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
        }catch (IOException e) {
            e.printStackTrace();
        }

        //db connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll()  {
        List<User> users = new ArrayList<>();
        try {
             PreparedStatement ps = conn.prepareStatement("select * from users");
             ResultSet rs =ps.executeQuery();
             while (rs.next()) {
                 User user = new User();
                 user.setName(rs.getString(1));
                 user.setSurname(rs.getString(2));
                 user.setEmail(rs.getString(3));
                 users.add(user);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public User getOne(String email) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users where email = ?"
            );
            ps.setString(1, email);
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setName(rs.getString(1));
                user.setSurname(rs.getString(2));
                user.setEmail(rs.getString(3));
                return user;
            }
        } catch (SQLException ignored) {
        }
        return null;
    }

    public void add(User user) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert  into users values(?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.execute();
        } catch (SQLException e ) {
            e.printStackTrace();
        }

    }

}