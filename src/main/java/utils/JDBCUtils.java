package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils {
    public static final String DATABASE_HOST = "jdbc:mysql://localhost:3306/humanResources";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "1234";


    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                DATABASE_HOST,
                DATABASE_USERNAME,
                DATABASE_PASSWORD
        );
    }
    public static void displayEmployees(ResultSet rs) throws SQLException{
        while(rs.next()){
            int employeeId=rs.getInt("employeeId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();
            String phoneNumber = rs.getString("phoneNumber");
            String email = rs.getString("email");
            int salary = rs.getInt("salary");

            System.out.println("Employee id : " + employeeId
                    + " , Employee first name : " + firstName
                    + " , Employee last name : " + lastName
                    + " , Employee date of birth : " + dateOfBirth
                    + " , Employee phone number : " + phoneNumber
                    + " , Employee email : " + email
                    + " , Employee salary : " + salary
            );
        }
    }
}
