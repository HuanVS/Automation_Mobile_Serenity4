package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {

    public static Connection createConnect(String url, String user, String pass) throws SQLException {
        Connection connect = DriverManager.getConnection(url, user, pass);
        connect.setAutoCommit(false);
        return connect;
    }

    public static String getAuthCode(String cif) {
        try {
            String sqlQuery = "select * from CUSTOMERS_PERSIST_SERVICE_E.customer where CIF_NUMBER = '" + cif + "'";
            Connection connect = createConnect("jdbc:oracle:thin:@10.1.14.214:1525:xe", "hydro_reader", "hydro_reader");
            Statement st = connect.createStatement();
            ResultSet resultSet = st.executeQuery(sqlQuery);
            resultSet.next();
            return resultSet.getString("HIGHRISK_AUTH_METHOD");
        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching auth code for CIF: " + cif, e);
        }
    }

}
