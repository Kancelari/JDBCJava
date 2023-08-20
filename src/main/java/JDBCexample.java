import utils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;

public class JDBCexample {
    public static void main(String[] args){
       try{
           Connection conn = DriverManager.getConnection(
                   JDBCUtils.DATABASE_HOST,
                   JDBCUtils.DATABASE_USERNAME,
                   JDBCUtils.DATABASE_PASSWORD
           );
           Statement statement = conn.createStatement();
           ResultSet resultset = statement.executeQuery("select employeeId, firstName, lastName, dateOfBirth from employees");
           System.out.println("-----------------Printo punonjesit qe fillojne me J-----------------");
           System.out.println();
           //Statement statement1 = conn.createStatement();
           ResultSet resultset1 = statement.executeQuery("select * from employees where firstname like 'J%'");
           JDBCUtils.displayEmployees(resultset1);
           System.out.println("-----------------Printo punonjesit qe nuk i perkasin asnje departamenti-----------------");
           System.out.println();
           ResultSet resultset2 = statement.executeQuery("select * from employees where departmentId is null");
           JDBCUtils.displayEmployees(resultset2);
           System.out.println("-----------------Display all employees along with the department they’re in -----------------");
           System.out.println();
           ResultSet resultset3 = statement.executeQuery("select e.*, d.* from employees e inner join departments d on e.departmentid=d.departmentid");
           JDBCUtils.displayEmployees(resultset3);
       }catch (SQLException e){
           e.printStackTrace();
           System.out.println("Not possible to connect with database");
       }
    }
}
