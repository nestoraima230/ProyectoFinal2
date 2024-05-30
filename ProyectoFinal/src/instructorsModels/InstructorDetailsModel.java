package instructorsModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDetailsModel {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";
    
    public InstructorDetailsModel() {
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public List<String> getInstructorSpecialties() {
        String query = "SELECT ESPECIALIDAD FROM INSTRUCTOR";
        List<String> instructorSpecialties = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                instructorSpecialties.add(rs.getString("ESPECIALIDAD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructorSpecialties;
    }
}
