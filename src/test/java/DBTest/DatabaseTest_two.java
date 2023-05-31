/*
package DBTest;
import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTest_two extends DBUtility {
    public static void main(String[] args) {



        try {
            // we need to establish the connection to the database
            System.out.println("Connection is established");
            // create a statement to send sql queries


            String query = "select * from person";
            ResultSet rSet = statement.executeQuery(query);
            ResultSetMetaData rsmData = rSet.getMetaData();

            // extract data from the result set and store it java data structure
            List<Map<String,String>> listFromSet = new ArrayList<>();
            // iterate through the rows
            while (rSet.next()){
                Map<String,String> map = new LinkedHashMap<>();
                // iterate through the columns
                for(int i = 1; i<=rsmData.getColumnCount(); i++){
                    // fetching key and value from the columns
                    String key = rsmData.getColumnName(i);
                    String value = rSet.getString(key);
                    map.put(key,value);
                }
                System.out.println(map);
                listFromSet.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

*/
