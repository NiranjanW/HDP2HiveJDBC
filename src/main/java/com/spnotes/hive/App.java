package com.spnotes.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main( String[] args )throws Exception{
        try {

            Class.forName(driverName);
            Connection connection = null;
                System.out.println("Before getting connection");
                connection=  DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "root", "hadoop");
                System.out.println("After getting connection " + connection);

                ResultSet resultSet = connection.createStatement().executeQuery("select * from default.employee");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
