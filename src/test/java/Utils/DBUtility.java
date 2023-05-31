package Utils;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    static Connection conn = null;
    static Statement statement = null;
    private static ResultSet rset;
    private static ResultSetMetaData resultSetMetaData;

    public static ResultSet getResultSet(String sqlquery){
        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("dburl"),
                    ConfigReader.getPropertyValue("dbusername"),
                    ConfigReader.getPropertyValue("dbpassword"));
            statement=conn.createStatement();
            rset=statement.executeQuery(sqlquery);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
return rset;
    }
    public static ResultSetMetaData getSetMetaData(String query){
        rset=getResultSet(query);
        resultSetMetaData=null;
        try {
            resultSetMetaData=rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return resultSetMetaData;

    }
    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        resultSetMetaData = getSetMetaData(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (rset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    //fetching key and value from the columns
                    String key = resultSetMetaData.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return listFromRset;
    }
    public static void closeResultSet(ResultSet rset){
        if(rset!=null){
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeStatement(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


}
