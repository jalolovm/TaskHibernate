package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private final String DB_URL = "jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Moscow&useSSL=false";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "NrPpetQEK3o%@5%";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static SessionFactory buildSessionFactory() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "NrPpetQEK3o%@5%");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/users?serverTimezone=UTC");
        properties.setProperty("show_sql", "true");

        Configuration cfg = new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(User.class);

        return cfg.buildSessionFactory();
    }

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }




    public static void close(){
        getSessionFactory().close();
    }

}