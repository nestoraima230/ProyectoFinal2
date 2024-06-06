package mainModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainRegisterModel {
    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";


    public boolean registerUser(String username, String password, String email) {
        String query = "INSERT INTO USUARIO_2 (NOMBRE, CONTRASENA, EMAIL) VALUES (?, ?, ?)";
        
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
