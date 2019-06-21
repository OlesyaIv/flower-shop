package com.flowershop.dao;

import com.flowershop.businesslogic.Item;
import utils.db_utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class ItemMapper {
    public static final String COLUMNS = "id, item_name, price, caterogy, quantity";
    private Map <Integer, Item> loadedMap = new HashMap<>();
    private Connection connection;

    public ItemMapper() throws SQLException
    {
        this.loadedMap = new HashMap<>();
        connection = db_utils.getInstance().getDataSource().getConnection();
    }
    public void addItem(Item item) throws SQLException {
        if (loadedMap.values().contains(item)) {
            update(item);
        } else {
            String insertSQL = "INSERT INTO item(item_name, price, caterogy, quantity) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setFloat(2, item.getItemPrice());
            preparedStatement.setString(3, item.getCategory());
            preparedStatement.setInt(4, item.getItemQuantity());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                item.setItemID(resultSet.getInt(1));
            }

            loadedMap.put(item.getItemID(), item);
        }
    }
    public void update(Item item) throws SQLException {
        if (loadedMap.values().contains(item)) {
            String updateSQL  = "UPDATE item item_name = ?, price = ?, category = ?, quantity = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setFloat(2, item.getItemPrice());
            preparedStatement.setString(3, item.getCategory());
            preparedStatement.setInt(4, item.getItemQuantity());
            preparedStatement.setInt(5, item.getItemID());
            preparedStatement.execute();

            loadedMap.replace(item.getItemID(), item);
        } else {
            addItem(item);
        }
    }
    public void update() throws SQLException {
        for (Item item : loadedMap.values())
            update(item);
    }
    public Item findItembyID(int id) throws SQLException {
        for (Item loadedItem : loadedMap.values()) {
            if (loadedItem.getItemID()== id)
                return loadedItem;
        }
        String selectSQL = "SELECT * FROM item WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) return null;
        String item_name = resultSet.getString("item_name");
        Float price = resultSet.getFloat("price");
        String cat = resultSet.getString("category");
        int quantity = resultSet.getInt("quantity");
        Item newItem = new Item(item_name,cat, id, price,quantity);
        loadedMap.put(id, newItem);
        return newItem;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public void clear() {
        loadedMap.clear();
    }

}