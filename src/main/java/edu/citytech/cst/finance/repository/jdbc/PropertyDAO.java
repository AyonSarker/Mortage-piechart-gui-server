package edu.citytech.cst.finance.repository.jdbc;


import edu.citytech.cst.finance.model.Property;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO- Data Access Object
public class PropertyDAO {

    static final String DB_URL = "jdbc:derby://localhost:1527/data/realEstate2022";
    static final String USER = "realEstate";
    static final String PASS = "pwd1234";
    static final String QUERY = """
                                 select id,
                                      cost,
                                      downPayment,
                                      netIncome ,
                                      state ,
                                      profitYear
                                      from properties
                                 """;

    public List<Property> findAll() {
        // Open a connection

        List<Property> properties = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name

                String id = rs.getString("id");
                float cost = rs.getFloat("cost");
                float downPayment = rs.getFloat("downPayment");
                String state = rs.getString("state");
                float netIncome = rs.getFloat("netIncome");
                int profitYear = rs.getInt("profitYear");


                Property property = new Property(id,cost,downPayment,state,netIncome,profitYear);
                properties.add(property);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;

    }
}
