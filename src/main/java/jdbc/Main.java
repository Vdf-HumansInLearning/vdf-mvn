package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    static final String tableSql = "CREATE TABLE IF NOT EXISTS employees"
        + "(employee_id int PRIMARY KEY AUTO_INCREMENT, name varchar(30),"
        + "position varchar(30), salary double)";

    private static final String insertSql =  "INSERT INTO employees(name, position, salary)"
        + " VALUES('smith', 'manager', 20000)";

    private static final String getSql = "SELECT * FROM employees";
    private static final String getSqlWithParam = "SELECT * FROM employees where position = ?";

    public static void main(String[] args) throws Exception {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vodafone", "root" , "root")) {
           Statement statement = connection.createStatement();
            System.out.println("Create table " + statement.execute(tableSql));
            System.out.println("Insert row " + statement.executeUpdate(insertSql));
            ResultSet result  = statement.executeQuery(getSql);
            System.out.println(result);
            while(result.next()) {
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getBigDecimal(4));
            }
            PreparedStatement ps = connection.prepareCall(getSqlWithParam);
            ps.setString(1, "developer");
            ResultSet employees = ps.executeQuery();
            while(employees.next()) {
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getBigDecimal(4));
            }
        }
    }

}
