package com.flowershop.dao;

import com.flowershop.user.Client;
import utils.db_utils;


import java.util.*;
import java.sql.Connection;
import java.sql.*;

public class ClientMapper {
    public static final String COLUMNS = "id,first_name, Surname, password, TeleNumber, Email";
    private Map <Integer, Client> loadedMap = new HashMap<>();
    private Connection connection;

    public ClientMapper() throws SQLException
    {

        connection = db_utils.getInstance().getDataSource().getConnection();
    }
    public void addClient(Client client) throws SQLException {
        if (loadedMap.values().contains(client)) {
            update(client);
        } else {
            String insertSQL = "INSERT INTO item(first_name, Surname, password, TeleNumber, Email) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getSurName());
            preparedStatement.setString(3, client.getPass());
            preparedStatement.setString(4, client.getTNumber());
            preparedStatement.setString(5, client.getEmail());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                client.setID(resultSet.getInt(1));
            }

            loadedMap.put(client.getID(), client);
        }
    }
    public void update(Client client) throws SQLException {
        if (loadedMap.values().contains(client)) {
            String updateSQL  = "UPDATE clients first_name = ?, Surname = ?, password = ?, TeleNumber = ?, Email = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getSurName());
            preparedStatement.setString(3, client.getPass());
            preparedStatement.setString(4, client.getTNumber());
            preparedStatement.setString(5, client.getEmail());
            preparedStatement.setInt(6, client.getID());
            preparedStatement.execute();

            loadedMap.replace(client.getID(), client);
        } else {
            addClient(client);
        }
    }
    public Client findClientForLogin(String email, String pass) throws SQLException {
        for (Client loadedClient : loadedMap.values()) {
            if (loadedClient.getEmail().equals(email)||loadedClient.getPass().equals(pass))
                return loadedClient;
        }
        String selectSQL = "SELECT * FROM clients WHERE Email = ? AND password = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, pass);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) return null;
        int id = resultSet.getInt("id");
        String password = resultSet.getString("password");
        String fname = resultSet.getString("first_name");
        String sname = resultSet.getString("Surname");
        String TeleNumber = resultSet.getString("TeleNumber");
        String Email = resultSet.getString("Email");
        Client newClient = new Client(fname, sname, id, TeleNumber,  Email, password);
        loadedMap.put(id, newClient);
        return newClient;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public void clear() {
        loadedMap.clear();
    }

}