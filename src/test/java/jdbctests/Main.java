package jdbctests;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@54.161.114.237:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("Select * from regions");

        while(resultSet.next()) {
            System.out.println(resultSet.getString("region_name"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
