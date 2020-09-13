package com.home.diana.dao;

import com.home.diana.io.FileIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static sun.plugin.javascript.navig.JSType.URL;

public class ConnectionFactory {

    private static final String PROPERTIES_FILE_NAME = "application.properties";
    private static final String KEY_DRIVER = "db.driver";
    private static final String KEY_URL = "db.url";
    private static final String KEY_USER = "db.user";
    private static final String KEY_PASSWORD = "db.password";
    private static FileIO fileIO = new FileIO();

    public static Connection getConnection() {
        Properties properties = fileIO.readProperties(PROPERTIES_FILE_NAME);
        String driver = properties.getProperty(KEY_DRIVER);
        String url = properties.getProperty(KEY_URL);
        String user = properties.getProperty(KEY_USER);
        String password = properties.getProperty(KEY_PASSWORD);

        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
