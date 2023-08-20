import utils.JDBCUtils;

import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(
                    JDBCUtils.DATABASE_HOST,
                    JDBCUtils.DATABASE_USERNAME,
                    JDBCUtils.DATABASE_PASSWORD
            );
            CallableStatement cstmt = conn.prepareCall("{ call FindEmployeesBySalarytest(?) }");
            cstmt.setInt(1,2000);
            ResultSet rs = cstmt.executeQuery();
            JDBCUtils.displayEmployees(rs);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
