package mainModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MainModel {
    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public MainModel() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM USUARIO WHERE NOMBRE = ? AND CONTRASENA = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful: " + rs.getInt(1) + " " + rs.getString(2), "Success", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed: Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerUser(String username, String password, String email) {
        String query = "INSERT INTO USUARIO (NOMBRE, CONTRASENA, EMAIL) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
