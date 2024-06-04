package instructorsModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditInstructorModel {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public EditInstructorModel() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public boolean updateInstructor(int id, String nombre, String apellidos, String especialidad, String email) {
        String query = "UPDATE INSTRUCTOR SET NOMBRE = ?, APELLIDOS = ?, ESPECIALIDAD = ?, EMAIL = ? WHERE INSTRUCTOR_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, especialidad);
            pstmt.setString(4, email);
            pstmt.setInt(5, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteInstructor(int id) {
        String deleteInscriptionQuery = "DELETE FROM INSCRIPCION WHERE CLASE_IMPARTIDA_ID IN (SELECT CLASE_IMPARTIDA_ID FROM CLASE_IMPARTIDA WHERE INSTRUCTOR_ID = ?)";
        String deleteAttendanceQuery = "DELETE FROM ASISTENCIA WHERE CLASE_IMPARTIDA_ID IN (SELECT CLASE_IMPARTIDA_ID FROM CLASE_IMPARTIDA WHERE INSTRUCTOR_ID = ?)";
        String deleteClaseImpartidaQuery = "DELETE FROM CLASE_IMPARTIDA WHERE INSTRUCTOR_ID = ?";
        String deleteInstructorQuery = "DELETE FROM INSTRUCTOR WHERE INSTRUCTOR_ID = ?";

        try (Connection con = getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement pstmt1 = con.prepareStatement(deleteInscriptionQuery);
                 PreparedStatement pstmt2 = con.prepareStatement(deleteAttendanceQuery);
                 PreparedStatement pstmt3 = con.prepareStatement(deleteClaseImpartidaQuery);
                 PreparedStatement pstmt4 = con.prepareStatement(deleteInstructorQuery)) {

                // Delete from INSCRIPCION
                pstmt1.setInt(1, id);
                pstmt1.executeUpdate();

                // Delete from ASISTENCIA
                pstmt2.setInt(1, id);
                pstmt2.executeUpdate();

                // Delete from CLASE_IMPARTIDA
                pstmt3.setInt(1, id);
                pstmt3.executeUpdate();

                // Delete from INSTRUCTOR
                pstmt4.setInt(1, id);
                pstmt4.executeUpdate();

                con.commit();
                return true;
            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
