package authModels;

//import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class instructorModels {

    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";

    public instructorModels() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // Add Instructor
    public boolean addInstructor(List<String> instructor) {
        String query = "INSERT INTO INSTRUCTOR (NOMBRE, APELLIDOS, ESPECIALIDAD, EMAIL) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, instructor.get(0));
            pstmt.setString(2, instructor.get(1));
            pstmt.setString(3, instructor.get(2));
            pstmt.setString(4, instructor.get(3));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Instructor Added: " + instructor.get(0) + "," + instructor.get(1) + "," + instructor.get(2) + "," + instructor.get(3));
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Consult Record
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

    // Edit Instructor
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

    // Instructor Details
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
    
    public boolean generateCredentialPDF(List<String> instructorDetails, String filePath) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Image logo = Image.getInstance("path/to/powerzone_logo.png"); 
            logo.scaleToFit(100, 100);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);

            Image instructorImage = Image.getInstance("path/to/instructor_image.png"); 
            instructorImage.scaleToFit(200, 200);
            instructorImage.setAlignment(Element.ALIGN_CENTER);
            document.add(instructorImage);

            Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph nombre = new Paragraph("Nombre: " + instructorDetails.get(0), font);
            nombre.setAlignment(Element.ALIGN_CENTER);
            document.add(nombre);

            Paragraph apellidos = new Paragraph("Apellidos: " + instructorDetails.get(1), font);
            apellidos.setAlignment(Element.ALIGN_CENTER);
            document.add(apellidos);

            Paragraph especialidad = new Paragraph("Especialidad: " + instructorDetails.get(2), font);
            especialidad.setAlignment(Element.ALIGN_CENTER);
            document.add(especialidad);

            Paragraph email = new Paragraph("Email: " + instructorDetails.get(3), font);
            email.setAlignment(Element.ALIGN_CENTER);
            document.add(email);

            BarcodeQRCode qrcode = new BarcodeQRCode(instructorDetails.get(3), 150, 150, null);
            Image qrImage = qrcode.getImage();
            qrImage.setAlignment(Element.ALIGN_CENTER);
            document.add(qrImage);

            document.close();
            return true;
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean generateReportPDF(List<List<String>> data, String filePath) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph title = new Paragraph("Carta de reporte", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph subtitle = new Paragraph("Instructores especializados en gimnasio y musculación", subtitleFont);
            subtitle.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle);

            document.add(new Paragraph("\n"));

            Font detailsFont = new Font(Font.FontFamily.HELVETICA, 12);
            Paragraph detail1 = new Paragraph("Capacidad para guiar y motivar a los clientes", detailsFont);
            detail1.setAlignment(Element.ALIGN_LEFT);
            document.add(detail1);

            Paragraph detail2 = new Paragraph("Certificados en reanimación cardiopulmonar y primeros auxilios", detailsFont);
            detail2.setAlignment(Element.ALIGN_LEFT);
            document.add(detail2);

            Paragraph detail3 = new Paragraph("Diseño de rutinas de ejercicios para mejorar la resistencia, la fuerza y la flexibilidad de los usuarios", detailsFont);
            detail3.setAlignment(Element.ALIGN_LEFT);
            document.add(detail3);

            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(4); // 4 columnas: Nombre, Apellidos, Especialidad, Email
            table.addCell("Nombre");
            table.addCell("Apellidos");
            table.addCell("Especialidad");
            table.addCell("Email");

            for (List<String> instructorDetails : data) {
                table.addCell(instructorDetails.get(0));
                table.addCell(instructorDetails.get(1));
                table.addCell(instructorDetails.get(2));
                table.addCell(instructorDetails.get(3));
            }

            document.add(table);
            document.close();
            return true;
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
