package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class jdbcexample {

    String dbUrl = "jdbc:oracle:thin:@54.161.114.237:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {


        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from regions");

   resultSet.next();
        System.out.println(resultSet.getString(1));
        resultSet.next();
        System.out.println(resultSet.getString(1));
        resultSet.beforeFirst();
        resultSet.next();
        System.out.println(resultSet.getString(1));

        resultSet.close();
        statement.close();
        connection.close();




    }
    @Test
    public void MetaDataExample() throws SQLException {


        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from regions");

        DatabaseMetaData dbMetaData = connection.getMetaData();

        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());
        System.out.println(dbMetaData.getDriverName());
        System.out.println(dbMetaData.getDriverVersion());

        ResultSetMetaData rsmd = resultSet.getMetaData();

        System.out.println(rsmd.getColumnCount());
        System.out.println(rsmd.getColumnName(1));

        resultSet.close();
        statement.close();
        connection.close();




    }

}
