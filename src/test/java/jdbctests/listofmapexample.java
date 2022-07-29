package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listofmapexample {


    String dbUrl = "jdbc:oracle:thin:@54.161.114.237:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";


    @Test
    public void test1() throws SQLException {


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from employees");

        ResultSetMetaData rsmd = resultSet.getMetaData();



        Map<String,Object> row1 = new HashMap<>();

        row1.put("first_name","Steven");
        row1.put("last_name","King");
        row1.put("salary",24000);
        row1.put("job_id","AD_PRES");

        System.out.println(row1.toString());

        Map<String,Object> row2 = new HashMap<>();

        row2.put("first_name","Neena");
        row2.put("last_name","Kochar");
        row2.put("salary",17000);
        row2.put("job_id","AD_VP");

        System.out.println(row2.toString());
        System.out.println(row2.get("salary"));

        Map<String,Object> row3 = new HashMap<>();

        resultSet.next();

        row3.put(rsmd.getColumnName(1),resultSet.getString(1));
        row3.put(rsmd.getColumnName(2),resultSet.getString(2));
        row3.put(rsmd.getColumnName(3),resultSet.getString(3));
        row3.put(rsmd.getColumnName(4),resultSet.getString(4));

        System.out.println(row3.toString());

        List<Map<String,Object>> queryData = new ArrayList<>();

        queryData.add(row1);
        queryData.add(row2);
        queryData.add(row3);

        System.out.println(queryData.get(0).get("salary"));
        System.out.println(queryData.get(2).get("EMPLOYEE_ID"));
        System.out.println(resultSet.getObject(1));


        resultSet.close();
        statement.close();
        connection.close();


    }
    }
