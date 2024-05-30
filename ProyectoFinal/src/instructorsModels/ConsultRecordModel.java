package instructorsModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultRecordModel {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";
    
    public ConsultRecordModel() {
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public List<String> getInstructorDetails(int instructorId) {
        String query = "SELECT NOMBRE, APELLIDOS, ESPECIALIDAD, EMAIL FROM INSTRUCTOR WHERE INSTRUCTOR_ID = ?";
        List<String> instructorDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, instructorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    instructorDetails.add(rs.getString("NOMBRE"));
                    instructorDetails.add(rs.getString("APELLIDOS"));
                    instructorDetails.add(rs.getString("ESPECIALIDAD"));
                    instructorDetails.add(rs.getString("EMAIL"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructorDetails;
    }

    public List<List<String>> getAllInstructors() {
        String query = "SELECT NOMBRE, APELLIDOS, ESPECIALIDAD, EMAIL FROM INSTRUCTOR";
        List<List<String>> allInstructors = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> instructorDetails = new ArrayList<>();
                instructorDetails.add(rs.getString("NOMBRE"));
                instructorDetails.add(rs.getString("APELLIDOS"));
                instructorDetails.add(rs.getString("ESPECIALIDAD"));
                instructorDetails.add(rs.getString("EMAIL"));
                allInstructors.add(instructorDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allInstructors;
    }
}
