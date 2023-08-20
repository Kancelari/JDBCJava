package repository;

import model.Department;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRepository implements Repository <Department, Integer> {
    public DepartmentRepository() {
    }

    @Override
    public Department findById(Integer id) {
        try(Connection conn = JDBCUtils.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("select * from departments where departmentId = ?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                return new Department(
                        rs.getInt("departmentId"),
                        rs.getString("name")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
