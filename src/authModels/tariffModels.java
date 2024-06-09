package authModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tariffModels {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public tariffModels() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public boolean addTariff(int clienteId, java.sql.Date fechaValidaInicial, java.sql.Date fechaValidaFinal, double costo) {
        String query = "INSERT INTO TARIFA (CLIENTE_ID, FECHA_VALIDA_INICIAL, FECHA_VALIDA_FINALIZADA, COSTO) VALUES (?, ?, ?, ?)";;

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, clienteId);
            pstmt.setDate(2, fechaValidaInicial);
            pstmt.setDate(3, fechaValidaFinal);
            pstmt.setDouble(4, costo); 

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getTariff(int id) {
        String query = "SELECT * FROM TARIFA WHERE TARIFA_ID = ?";
        List<String> tariffDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tariffDetails.add(String.valueOf(rs.getInt("TARIFA_ID")));
                    tariffDetails.add(String.valueOf(rs.getInt("CLIENTE_ID")));
                    tariffDetails.add(rs.getDate("FECHA_VALIDA_INICIAL").toString());
                    tariffDetails.add(rs.getDate("FECHA_VALIDA_FINALIZADA").toString());
                    tariffDetails.add(String.valueOf(rs.getDouble("COSTO")));
                    tariffDetails.add(rs.getString("NOMBRE")); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tariffDetails;
    }
    
    public String getNombreClient(int clientid) {
        String query = "SELECT NOMBRE FROM CLIENTE WHERE CLIENTE_ID = ?";
        String nombreInstructor = null;

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, clientid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    nombreInstructor = rs.getString("NOMBRE");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreInstructor;
    }

    

    public List<List<String>> getAllTariffs() {
        String query = "SELECT t.TARIFA_ID, t.CLIENTE_ID, c.NOMBRE AS NOMBRE_CLIENTE, t.FECHA_VALIDA_INICIAL, t.FECHA_VALIDA_FINALIZADA, t.COSTO, t.NOMBRE " +
                       "FROM TARIFA t JOIN CLIENTE c ON t.CLIENTE_ID = c.CLIENTE_ID";
        List<List<String>> allTariffs = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> tariffDetails = new ArrayList<>();
                tariffDetails.add(String.valueOf(rs.getInt("TARIFA_ID")));
                tariffDetails.add(rs.getString("NOMBRE_CLIENTE")); 
                tariffDetails.add(rs.getDate("FECHA_VALIDA_INICIAL").toString());
                tariffDetails.add(rs.getDate("FECHA_VALIDA_FINALIZADA").toString());
                tariffDetails.add(String.valueOf(rs.getDouble("COSTO"))); 
                tariffDetails.add(rs.getString("NOMBRE")); 
                allTariffs.add(tariffDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTariffs;
    }

    
    public boolean deleteTariff(int id) {
        String query = "DELETE FROM TARIFA WHERE TARIFA_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateTariff(int id, int clienteId, java.sql.Date fechaValidaInicial, java.sql.Date fechaValidaFinal, double costo, String nombre) {
        String query = "UPDATE TARIFA SET CLIENTE_ID = ?, FECHA_VALIDA_INICIAL = ?, FECHA_VALIDA_FINALIZADA = ?, COSTO = ?, NOMBRE = ? WHERE TARIFA_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, clienteId);
            pstmt.setDate(2, fechaValidaInicial);
            pstmt.setDate(3, fechaValidaFinal);
            pstmt.setDouble(4, costo);
            pstmt.setString(5, nombre);
            pstmt.setInt(6, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
