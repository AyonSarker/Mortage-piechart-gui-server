package edu.citytech.cst.finance.test.jdbc;

import edu.citytech.cst.finance.model.Property;
import edu.citytech.cst.finance.repository.jdbc.PropertyDAO;

import java.util.Locale;
import java.util.function.Consumer;

public class T1_DAO {

    public static void myPrinter(Property p){
        System.out.println((p + "").toLowerCase());
    }

    public  void myPrinter2(Property p){
        System.out.println((p + "").toUpperCase());
    }

    public static void main(String[] args) {



        PropertyDAO propertyDAO = new PropertyDAO();

        propertyDAO.findAll().forEach(System.out::println);
    }
}
