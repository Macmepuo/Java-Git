package ru.geekbrains.server;

import java.sql.*;

public class SQLHandler {
    private static Connection connection;
    private static Statement statement;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:server/database.db");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPassword(String login, String password) throws Exception {
        try {
            ResultSet rs = statement.executeQuery("SELECT nickname FROM users WHERE login ='" + checkNull(login) + "' AND password = '" + checkNull(password) + "'");
            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String ChangeNick(String nick, String oldnick) throws Exception {
        String nick1=checkNull(nick);
        String nick2=checkNull(oldnick);
        try {
            ResultSet rs = statement.executeQuery("UPDATE users SET nickname ='" + nick1 + "' WHERE nickname = '" + nick2 + "'");
            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean tryToRegister(String login, String password, String nickname) throws Exception {
        try {
            statement.executeUpdate("INSERT INTO users (login, password, nickname) VALUES ('" + checkNull(login) + "','" + checkNull(password) + "','" + checkNull(nickname) + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private static String checkNull(String currentString) throws Exception{
        if(currentString==null){
            throw new Exception("некорректно");
        }
        return currentString.trim();
    }
}
