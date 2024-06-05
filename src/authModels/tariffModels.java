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

    public boolean addTariff(int clienteId, java.sql.Date fechaValidaInicial, java.sql.Date fechaValidaFinal) {
        String query = "INSERT INTO tariff (cliente_id, fecha_valida_inicial, fecha_valida_final) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, clienteId);
            pstmt.setDate(2, fechaValidaInicial);
            pstmt.setDate(3, fechaValidaFinal);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getTariff(int id) {
        String query = "SELECT * FROM tariff WHERE id = ?";
        List<String> tariffDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tariffDetails.add(String.valueOf(rs.getInt("id")));
                    tariffDetails.add(String.valueOf(rs.getInt("cliente_id")));
                    tariffDetails.add(rs.getDate("fecha_valida_inicial").toString());
                    tariffDetails.add(rs.getDate("fecha_valida_final").toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tariffDetails;
    }

    public List<List<String>> getAllTariffs() {
        String query = "SELECT * FROM tariff";
        List<List<String>> allTariffs = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> tariffDetails = new ArrayList<>();
                tariffDetails.add(String.valueOf(rs.getInt("id")));
                tariffDetails.add(String.valueOf(rs.getInt("cliente_id")));
                tariffDetails.add(rs.getDate("fecha_valida_inicial").toString());
                tariffDetails.add(rs.getDate("fecha_valida_final").toString());
                allTariffs.add(tariffDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTariffs;
    }

    public boolean updateTariff(int id, int clienteId, java.sql.Date fechaValidaInicial, java.sql.Date fechaValidaFinal) {
        String query = "UPDATE tariff SET cliente_id = ?, fecha_valida_inicial = ?, fecha_valida_final = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, clienteId);
            pstmt.setDate(2, fechaValidaInicial);
            pstmt.setDate(3, fechaValidaFinal);
            pstmt.setInt(4, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTariff(int id) {
        String query = "DELETE FROM tariff WHERE id = ?";

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
}
