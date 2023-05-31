package DBTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatatbaseTest {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username= "syntax_hrm";
        String password= "syntaxhrm123";

        try {
            Connection conn=DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch15");
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery("select FirstName, LastName, age, city from person where city is not null;");
            ResultSetMetaData metaData= resultSet.getMetaData();
            for(int i=1; i< metaData.getColumnCount();i++){
                String columnName=metaData.getColumnName(i);
                System.out.println(columnName);
            }
            while(resultSet.next()){
                for (int i=1;i<=metaData.getColumnCount();i++){
                    String value=resultSet.getString(metaData.getColumnName(i));
                    System.out.print(value+" ");
                    System.out.println("");
                }
            }
/*
            while(resultSet.next()) {
                String fName = resultSet.getString("FirstName");
                String lName = resultSet.getString("LastName");
                System.out.println((fName+" "+lName));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
