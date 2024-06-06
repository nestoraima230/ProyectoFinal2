package authModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class classModels {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public classModels() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public boolean addClase(String nombre, String tipoClase, String descripcion, String nivelDificultad, 
                            java.sql.Date fechaInicio, java.sql.Date fechaFin, Time duracion, 
                            int instructorId, int capacidadMaxima) {
        String query = "INSERT INTO clase (nombre, tipo_clase, descripcion, nivel_dificultad, fecha_inicio, fecha_fin, duracion, instructor_id, capacidad_maxima) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, tipoClase);
            pstmt.setString(3, descripcion);
            pstmt.setString(4, nivelDificultad);
            pstmt.setDate(5, fechaInicio);
            pstmt.setDate(6, fechaFin);
            pstmt.setTime(7, duracion);
            pstmt.setInt(8, instructorId);
            pstmt.setInt(9, capacidadMaxima);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener una clase por ID
    public List<String> getClase(int id) {
        String query = "SELECT * FROM clase WHERE id = ?";
        List<String> claseDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    claseDetails.add(String.valueOf(rs.getInt("id")));
                    claseDetails.add(rs.getString("nombre"));
                    claseDetails.add(rs.getString("tipo_clase"));
                    claseDetails.add(rs.getString("descripcion"));
                    claseDetails.add(rs.getString("nivel_dificultad"));
                    claseDetails.add(rs.getDate("fecha_inicio").toString());
                    claseDetails.add(rs.getDate("fecha_fin").toString());
                    claseDetails.add(rs.getTime("duracion").toString());
                    claseDetails.add(String.valueOf(rs.getInt("instructor_id")));
                    claseDetails.add(String.valueOf(rs.getInt("capacidad_maxima")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claseDetails;
    }


    public List<List<String>> getAllClases() {
        String query = "SELECT * FROM clase";
        List<List<String>> allClases = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> claseDetails = new ArrayList<>();
                claseDetails.add(String.valueOf(rs.getInt("id")));
                claseDetails.add(rs.getString("nombre"));
                claseDetails.add(rs.getString("tipo_clase"));
                claseDetails.add(rs.getString("descripcion"));
                claseDetails.add(rs.getString("nivel_dificultad"));
                claseDetails.add(rs.getDate("fecha_inicio").toString());
                claseDetails.add(rs.getDate("fecha_fin").toString());
                claseDetails.add(rs.getTime("duracion").toString());
                claseDetails.add(String.valueOf(rs.getInt("instructor_id")));
                claseDetails.add(String.valueOf(rs.getInt("capacidad_maxima")));
                allClases.add(claseDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allClases;
    }

    public boolean updateClase(int id, String nombre, String tipoClase, String descripcion, String nivelDificultad, 
                               java.sql.Date fechaInicio, java.sql.Date fechaFin, Time duracion, 
                               int instructorId, int capacidadMaxima) {
        String query = "UPDATE clase SET nombre = ?, tipo_clase = ?, descripcion = ?, nivel_dificultad = ?, fecha_inicio = ?, fecha_fin = ?, duracion = ?, instructor_id = ?, capacidad_maxima = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, tipoClase);
            pstmt.setString(3, descripcion);
            pstmt.setString(4, nivelDificultad);
            pstmt.setDate(5, fechaInicio);
            pstmt.setDate(6, fechaFin);
            pstmt.setTime(7, duracion);
            pstmt.setInt(8, instructorId);
            pstmt.setInt(9, capacidadMaxima);
            pstmt.setInt(10, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una clase
    public boolean deleteClase(int id) {
        String query = "DELETE FROM clase WHERE id = ?";

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
