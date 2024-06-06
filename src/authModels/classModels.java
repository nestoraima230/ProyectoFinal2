package authModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
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

    public boolean addClase(String NOMBRE, java.sql.Timestamp HORARIO, java.sql.Time DURACION, 
                            int INSTRUCTOR_ID, int CAPACIDAD_MAXIMA) {
        String query = "INSERT INTO CLASE (NOMBRE, HORARIO, DURACION, INSTRUCTOR_ID, CAPACIDAD_MAXIMA) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, NOMBRE);
            pstmt.setTimestamp(2, HORARIO);
            pstmt.setTime(3, DURACION);
            pstmt.setInt(4, INSTRUCTOR_ID);
            pstmt.setInt(5, CAPACIDAD_MAXIMA);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getClase(int ID) {
        String query = "SELECT * FROM CLASE WHERE CLASE_ID = ?";
        List<String> claseDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    claseDetails.add(String.valueOf(rs.getInt("CLASE_ID")));
                    claseDetails.add(rs.getString("NOMBRE"));
                    claseDetails.add(rs.getTime("HORARIO").toString());
                    claseDetails.add(rs.getTime("DURACION").toString());
                    claseDetails.add(String.valueOf(rs.getInt("INSTRUCTOR_ID")));
                    claseDetails.add(String.valueOf(rs.getInt("CAPACIDAD_MAXIMA")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claseDetails;
    }

    public List<List<String>> getAllClases() {
        String query = "SELECT c.CLASE_ID, c.NOMBRE, c.HORARIO, c.DURACION, i.NOMBRE AS NOMBRE_INSTRUCTOR, c.CAPACIDAD_MAXIMA " +
                       "FROM CLASE c " +
                       "JOIN INSTRUCTOR i ON c.INSTRUCTOR_ID = i.INSTRUCTOR_ID";
        List<List<String>> allClases = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> claseDetails = new ArrayList<>();
                claseDetails.add(String.valueOf(rs.getInt("CLASE_ID")));
                claseDetails.add(rs.getString("NOMBRE"));
                claseDetails.add(rs.getTime("HORARIO").toString());
                claseDetails.add(rs.getTime("DURACION").toString());
                claseDetails.add(rs.getString("NOMBRE_INSTRUCTOR"));
                claseDetails.add(String.valueOf(rs.getInt("CAPACIDAD_MAXIMA")));
                allClases.add(claseDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allClases;
    }


    public boolean deleteClase(int ID) {
        String query = "DELETE FROM CLASE WHERE CLASE_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, ID);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getDetallesClase(String nombreClase) {
        String query = "SELECT * FROM CLASE WHERE NOMBRE = ?";
        List<String> claseDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, nombreClase);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    claseDetails.add(String.valueOf(rs.getInt("CLASE_ID")));
                    claseDetails.add(rs.getString("NOMBRE"));
                    claseDetails.add(rs.getTime("DURACION").toString());
                    claseDetails.add(rs.getTimestamp("HORARIO").toString());
                    claseDetails.add(String.valueOf(rs.getInt("CAPACIDAD_MAXIMA")));
                    claseDetails.add(String.valueOf(rs.getInt("INSTRUCTOR_ID")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claseDetails;
    }

	public boolean updateClase(String nombre, Timestamp horario, Time duracion, int instructorId, int capacidadMaxima) {
		  String query = "UPDATE CLASE SET NOMBRE = ?, HORARIO = ?, DURACION = ?, INSTRUCTOR_ID = ?, CAPACIDAD_MAXIMA = ? WHERE CLASE_ID = ?";
	        try (Connection con = getConnection();
	                PreparedStatement pstmt = con.prepareStatement(query)) {

	               pstmt.setString(1, nombre);
	               pstmt.setTimestamp(2, horario);
	               pstmt.setTime(3, duracion);
	               pstmt.setInt(4, instructorId);
	               pstmt.setInt(5, capacidadMaxima);

	               int rowsAffected = pstmt.executeUpdate();
	               return rowsAffected > 0;
	           } catch (SQLException e) {
	               e.printStackTrace();
	               return false;
	           }
	}

}
