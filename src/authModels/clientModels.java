package authModels;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class clientModels {

	
    private static final String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_gimnasio";
    private static final String JDBC_USER = "freedb_nestor_arce";
    private static final String JDBC_PASSWORD = "uwDrTJ7Xw!a8v!r";
    
    public clientModels() {
    	
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public boolean addClient(List<String> client) {
        String query = "INSERT INTO CLIENTE (NOMBRE, APELLIDOS, FECHA_NACIMIENTO, TELEFONO) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, client.get(0));
            pstmt.setString(2, client.get(1));
            pstmt.setString(3, client.get(2));
            pstmt.setString(4, client.get(3));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client Added: " + client.get(0) + "," + client.get(1) + "," + client.get(2) + "," + client.get(3));
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateClient(int id, List<String> newClientDetails) {
        String query = "UPDATE CLIENTE SET NOMBRE = ?, APELLIDOS = ?, FECHA_NACIMIENTO = ?, TELEFONO = ? WHERE CLIENTE_ID = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, newClientDetails.get(0));
            pstmt.setString(2, newClientDetails.get(1));
            pstmt.setString(3, newClientDetails.get(2));
            pstmt.setString(4, newClientDetails.get(3));
            pstmt.setInt(5, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client Updated: ID=" + id + ", Name=" + newClientDetails.get(0) + ", Lastname=" + newClientDetails.get(1) + ", Birthday=" + newClientDetails.get(2) + ", Phone=" + newClientDetails.get(3));
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    
    public List<String> getClientDetails(int clientId) {
        String query = "SELECT c.CLIENTE_ID, c.NOMBRE, c.APELLIDOS, c.FECHA_NACIMIENTO, c.TELEFONO, p.MONTO " +
                       "FROM CLIENTE c " +
                       "LEFT JOIN PAGO p ON c.CLIENTE_ID = p.CLIENTE_ID " +
                       "WHERE c.CLIENTE_ID = ?";
        List<String> clientDetails = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clientDetails.add(rs.getString("NOMBRE"));
                    clientDetails.add(rs.getString("APELLIDOS"));
                    clientDetails.add(rs.getString("CLIENTE_ID"));
                    clientDetails.add(rs.getString("TELEFONO"));
                    clientDetails.add(rs.getString("FECHA_NACIMIENTO"));
                    String monto = rs.getString("MONTO");
                    clientDetails.add(monto != null ? monto : "0.0");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientDetails;
    }
    
    public List<List<String>> getAllClients() {
        String query = "SELECT NOMBRE, CLIENTE_ID, APELLIDOS,FECHA_NACIMIENTO, TELEFONO FROM CLIENTE";
        List<List<String>> allClients = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> clientDetails = new ArrayList<>();
                clientDetails.add(rs.getString("NOMBRE"));
                clientDetails.add(rs.getString("CLIENTE_ID"));
                clientDetails.add(rs.getString("APELLIDOS"));
                clientDetails.add(rs.getString("FECHA_NACIMIENTO"));
                clientDetails.add(rs.getString("TELEFONO"));
                allClients.add(clientDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allClients;
    }

    public List<List<String>> getClientClasses(int clientId) {
        String query = "SELECT c.NOMBRE, ci.FECHA_HORA " +
                       "FROM ASISTENCIA a " +
                       "INNER JOIN CLASE_IMPARTIDA ci ON a.CLASE_IMPARTIDA_ID = ci.CLASE_ID " +
                       "INNER JOIN CLASE c ON ci.CLASE_ID = c.CLASE_ID " +
                       "WHERE a.CLIENTE_ID = ?";
        List<List<String>> classes = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    List<String> classDetails = new ArrayList<>();
                    classDetails.add(rs.getString("NOMBRE"));
                    classDetails.add(rs.getString("FECHA_HORA"));
                    classes.add(classDetails);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }


    public List<List<String>> getClientPayments(int clientId) {
        String query = "SELECT FECHA_PAGO, MONTO FROM PAGO WHERE CLIENTE_ID = ?";
        List<List<String>> payments = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    List<String> paymentDetails = new ArrayList<>();
                    paymentDetails.add(rs.getString("FECHA_PAGO"));
                    paymentDetails.add(rs.getString("MONTO"));
                    payments.add(paymentDetails);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    public List<List<String>> getClientAttendances(int clientId) {
        String query = "SELECT FECHA_ASISTENCIA FROM ASISTENCIA WHERE CLIENTE_ID = ?";
        List<List<String>> attendances = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    List<String> attendanceDetails = new ArrayList<>();
                    attendanceDetails.add(rs.getString("FECHA_ASISTENCIA"));
                    attendances.add(attendanceDetails);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    
    public boolean deleteClient(int id) {
    	
        String deleteTarifaQuery = "DELETE FROM TARIFA WHERE CLIENTE_ID = ?";
        String deleteClientQuery = "DELETE FROM CLIENTE WHERE CLIENTE_ID = ?";
        String deleteAssistQuery = "DELETE FROM ASISTENCIA WHERE CLIENTE_ID = ?";
        String deleteInscriptionQuery = "DELETE FROM INSCRIPCION WHERE CLIENTE_ID = ?";
        String deletePayQuery = "DELETE FROM PAGO WHERE CLIENTE_ID = ?";
        
        try (Connection con = getConnection();
             PreparedStatement pstmtDeleteTarifa = con.prepareStatement(deleteTarifaQuery);
             PreparedStatement pstmtDeleteClient = con.prepareStatement(deleteClientQuery); 
             PreparedStatement pstmtDeleteAssist = con.prepareStatement(deleteAssistQuery);
        	 PreparedStatement pstmtDeleteInscription = con.prepareStatement(deleteInscriptionQuery);
        	 PreparedStatement pstmtDeletePay= con.prepareStatement(deletePayQuery)){
            
            pstmtDeleteTarifa.setInt(1, id);
            pstmtDeleteTarifa.executeUpdate();
            
            pstmtDeleteAssist.setInt(1, id);
            pstmtDeleteAssist.executeUpdate();
            
            pstmtDeleteInscription.setInt(1, id);
            pstmtDeleteInscription.executeUpdate();
            
            pstmtDeletePay.setInt(1, id);
            pstmtDeletePay.executeUpdate();
            
            pstmtDeleteClient.setInt(1, id);
            int rowsAffected = pstmtDeleteClient.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Client deleted: ID=" + id);
                return true;
            } else {
                System.out.println("No client found with ID=" + id);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    
    public int buscarIdCliente(String nombre, String apellidos, String fechaNacimiento, String telefono) {
        String query = "SELECT CLIENTE_ID FROM CLIENTE WHERE NOMBRE = ? AND APELLIDOS = ? AND FECHA_NACIMIENTO = ? AND TELEFONO = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, fechaNacimiento);
            pstmt.setString(4, telefono);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("CLIENTE_ID");
            } else {
                return -1; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; 
        }
    }

    
    public boolean generarPDFCredencialCliente(List<String> clienteDetails, String logoPath, String clienteImagePath, String filePath) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 1});
            
            PdfPCell cellFrontal = new PdfPCell();
            cellFrontal.setBorder(Rectangle.NO_BORDER);
            
            com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance(logoPath); 
            logo.scaleToFit(100, 100);
            logo.setAlignment(Element.ALIGN_CENTER);
            cellFrontal.addElement(logo);

            com.itextpdf.text.Image clienteImage = com.itextpdf.text.Image.getInstance(clienteImagePath); 
            clienteImage.scaleToFit(200, 200);
            clienteImage.setAlignment(Element.ALIGN_CENTER);
            cellFrontal.addElement(clienteImage);

            Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph nombre = new Paragraph(clienteDetails.get(0), font);
            nombre.setAlignment(Element.ALIGN_CENTER);
            cellFrontal.addElement(nombre);

            table.addCell(cellFrontal);
            
            PdfPCell cellTrasera = new PdfPCell();
            cellTrasera.setBorder(Rectangle.NO_BORDER);
            
            Barcode128 code128 = new Barcode128();
            code128.setCode(clienteDetails.get(1));
            com.itextpdf.text.Image code128Image = code128.createImageWithBarcode(null, null, null);
            code128Image.setAlignment(Element.ALIGN_CENTER);
            cellTrasera.addElement(code128Image);
            
            BarcodeQRCode qrcode = new BarcodeQRCode(clienteDetails.get(1), 150, 150, null);
            com.itextpdf.text.Image qrImage = qrcode.getImage();
            qrImage.setAlignment(Element.ALIGN_CENTER);
            cellTrasera.addElement(qrImage);

            Paragraph contacto = new Paragraph("612 345 1290", font);
            contacto.setAlignment(Element.ALIGN_CENTER);
            cellTrasera.addElement(contacto);

            Paragraph slogan = new Paragraph("¡Unete a nuestra familia!", font);
            slogan.setAlignment(Element.ALIGN_CENTER);
            cellTrasera.addElement(slogan);

            table.addCell(cellTrasera);

            document.add(table);
            document.close();
            return true;
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean generarPDFReporteCliente(List<String> clienteDetails, List<String> reportDetails, String filePath) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Carta de reporte", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            document.add(Chunk.NEWLINE);

            Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph subtitle = new Paragraph("Instructores especializados en gimnasio y musculación", subtitleFont);
            subtitle.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle);

            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{2, 5});

            PdfPCell cell1 = new PdfPCell(new Phrase("Categoría", subtitleFont));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Phrase("Descripción", subtitleFont));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell2);

            Font contentFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            for (int i = 0; i < reportDetails.size(); i++) {
                table.addCell(new PdfPCell(new Phrase(reportDetails.get(i), contentFont)));
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
