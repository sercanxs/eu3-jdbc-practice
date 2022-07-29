package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamic_list {

    String dbUrl = "jdbc:oracle:thin:@54.161.114.237:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";


    @Test
    public void test1() throws SQLException {


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from employees");

        ResultSetMetaData rsmd = resultSet.getMetaData();

        List<Map<String,Object>> queryData = new ArrayList<>();

        int colCount = rsmd.getColumnCount();

        while (resultSet.next()){

            Map<String,Object> row = new HashMap<>();

            for (int i = 1; i <= colCount; i++) {

row.put(rsmd.getColumnName(i),resultSet.getObject(i));
            }
            queryData.add(row);

        }

        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }



        resultSet.close();
        statement.close();
        connection.close();


    }


}
