import utils.JDBCUtils;
import java.sql.*;
public class PreparedStatementExample {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(
                    JDBCUtils.DATABASE_HOST,
                    JDBCUtils.DATABASE_USERNAME,
                    JDBCUtils.DATABASE_PASSWORD
            );
            PreparedStatement preparedstatement = conn.prepareStatement("Select * from employees where firstName = ?");
            preparedstatement.setString(1,"John");
            ResultSet resultset = preparedstatement.executeQuery();
            JDBCUtils.displayEmployees(resultset);
            System.out.println();
            PreparedStatement preparedstatement1 = conn.prepareStatement("Select * from employees where salary > ?");
            preparedstatement1.setInt(1,2000);
            ResultSet resultset2 = preparedstatement1.executeQuery();
            JDBCUtils.displayEmployees(resultset2);
            System.out.println();
            String insertIntoEmployees = "INSERT INTO employees (firstname, lastname, dateOfBirth, phoneNumber, email, salary) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertIntoEmployees);
            stmt.setString(1,"Afrim");
            stmt.setString(2,"Patalaku");
            stmt.setDate(3, Date.valueOf("1989-03-07"));
            stmt.setString(4, "0800-800-800");
            stmt.setString(5,"m@matthews.gmail.com");
            stmt.setInt(6,3000);
            int insertedrow = stmt.executeUpdate();
            System.out.println(insertedrow);
    } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Not possible to connect with database");
        }
    }
}
