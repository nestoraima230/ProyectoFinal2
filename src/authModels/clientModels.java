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
    
    public List<String> getClientDetails(int clientId) {
        String query = "SELECT NOMBRE, TELEFONO, FECHA_NACIMIENTO FROM CLIENTE WHERE CLIENTE = ?";
        List<String> clientDetails = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clientDetails.add(rs.getString("NOMBRE"));
                    clientDetails.add(rs.getString("TELEFONO"));
                    clientDetails.add(rs.getString("FECHA_NACIMIENTO"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientDetails;
    }
    
    public List<List<String>> getAllClients() {
        String query = "SELECT NOMBRE, APELLIDOS, TELEFONO, FROM INSTRUCTOR";
        List<List<String>> allClients = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                List<String> clientDetails = new ArrayList<>();
                clientDetails.add(rs.getString("NOMBRE"));
                clientDetails.add(rs.getString("APELLIDOS"));
                clientDetails.add(rs.getString("TELEFONO"));
                allClients.add(clientDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allClients;
    }
    
    public boolean deleteClient(int id) {
        String getClientQuery = "SELECT NOMBRE, APELLIDOS, FECHA_NACIMIENTO, TELEFONO FROM CLIENTE WHERE CLIENTE_ID = ?";
        String deleteClientQuery = "DELETE FROM CLIENTE WHERE CLIENTE_ID = ?";
        
        try (Connection con = getConnection();
             PreparedStatement pstmtSelect = con.prepareStatement(getClientQuery);
             PreparedStatement pstmtDelete = con.prepareStatement(deleteClientQuery)) {
            
            pstmtSelect.setInt(1, id);
            ResultSet rs = pstmtSelect.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String apellidos = rs.getString("APELLIDOS");
                String fechaNacimiento = rs.getString("FECHA_NACIMIENTO");
                String telefono = rs.getString("TELEFONO");
                
                pstmtDelete.setInt(1, id);
                pstmtDelete.executeUpdate();
                
                System.out.println("Client deleted: ID=" + id + ", Name=" + nombre + ", Lastname=" + apellidos + ", Birthday=" + fechaNacimiento + ", Phone=" + telefono);
                
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
