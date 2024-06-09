package clientView;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import authControllers.clientControllers;

public class ClientDetail {

    private JFrame frame;
    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JTextField textFieldBirthDay;
    private JTextField textFieldBirthYear;
    private JTable table;

    private clientControllers controller;

    public static void main(String[] args) {
        if (args.length > 0) {
            int clientId = Integer.parseInt(args[0]);
            EventQueue.invokeLater(() -> {
                try {
                    ClientDetail window = new ClientDetail(clientId);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public ClientDetail(int clientId) {
        initialize();
        controller = new clientControllers();
        cargarInformacionCliente(clientId);
        cargarDatosTabla(clientId);
    }

    private void cargarInformacionCliente(int clientId) {
        List<String> clienteDetails = controller.getClientDetails(clientId);
        if (!clienteDetails.isEmpty()) {
            textFieldName.setText(clienteDetails.get(0));
            textFieldPhone.setText(clienteDetails.get(3));
            textFieldBirthDay.setText(clienteDetails.get(4));
            textFieldBirthYear.setText(clienteDetails.get(2));
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnReporte = new JButton("Reporte");
        btnReporte.setForeground(new Color(255, 255, 255));
        btnReporte.setBackground(new Color(0, 0, 0));
        btnReporte.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        btnReporte.setBounds(279, 451, 150, 21);
        panel.add(btnReporte);

        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ClientReport clientReportWindow = new ClientReport();
                clientReportWindow.getFrame().setVisible(true);
            }
        });

        JLabel lblTrainer = new JLabel("Clase");
        lblTrainer.setForeground(new Color(255, 255, 255));
        lblTrainer.setBackground(new Color(0, 0, 0));
        lblTrainer.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblTrainer.setOpaque(true);
        lblTrainer.setBounds(73, 258, 178, 13);
        panel.add(lblTrainer);

        JLabel lblPayments = new JLabel("Pagos");
        lblPayments.setForeground(new Color(255, 255, 255));
        lblPayments.setBackground(new Color(0, 0, 0));
        lblPayments.setOpaque(true);
        lblPayments.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblPayments.setBounds(250, 259, 190, 13);
        panel.add(lblPayments);

        JLabel lblAttendance = new JLabel("Asistencia");
        lblAttendance.setBackground(new Color(0, 0, 0));
        lblAttendance.setForeground(new Color(255, 255, 255));
        lblAttendance.setOpaque(true);
        lblAttendance.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblAttendance.setBounds(440, 258, 183, 13);
        panel.add(lblAttendance);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(61, 271, 576, 150);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(61, 30, 573, 450);
        panel.add(panel_1);
        panel_1.setLayout(null);

        textFieldName = new JTextField();
        textFieldName.setBounds(20, 67, 315, 21);
        panel_1.add(textFieldName);
        textFieldName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        textFieldName.setBackground(new Color(255, 255, 255));
        textFieldName.setColumns(10);

        JLabel lblName = new JLabel("Nombre");
        lblName.setBounds(20, 49, 105, 21);
        panel_1.add(lblName);
        lblName.setFont(new Font("Tw Cen MT", Font.BOLD, 18));

        JLabel lblNewLabel = new JLabel("Detalles de cliente");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
        lblNewLabel.setBounds(168, 10, 296, 47);
        panel_1.add(lblNewLabel);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 241, 553, 150);
        panel_1.add(scrollPane_1);

        table = new JTable();
        scrollPane_1.setViewportView(table);

        textFieldBirthDay = new JTextField();
        textFieldBirthDay.setBounds(20, 192, 151, 29);
        panel_1.add(textFieldBirthDay);
        textFieldBirthDay.setColumns(10);
        textFieldBirthDay.setBackground(new Color(255, 255, 255));
        textFieldBirthDay.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        JLabel lblBirthDate = new JLabel("Fecha de nacimiento");
        lblBirthDate.setBounds(20, 173, 196, 21);
        panel_1.add(lblBirthDate);
        lblBirthDate.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

        textFieldBirthYear = new JTextField();
        textFieldBirthYear.setBounds(271, 190, 65, 29);
        panel_1.add(textFieldBirthYear);
        textFieldBirthYear.setColumns(10);
        textFieldBirthYear.setBackground(new Color(255, 255, 255));
        textFieldBirthYear.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        textFieldPhone = new JTextField();
        textFieldPhone.setBounds(20, 130, 315, 21);
        panel_1.add(textFieldPhone);
        textFieldPhone.setColumns(10);
        textFieldPhone.setBackground(new Color(255, 255, 255));
        textFieldPhone.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        JLabel lblPhone = new JLabel("Telefono");
        lblPhone.setBounds(20, 108, 105, 21);
        panel_1.add(lblPhone);
        lblPhone.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

        JButton btnCredencial = new JButton("Credencial");
        btnCredencial.setBounds(10, 419, 128, 21);
        panel_1.add(btnCredencial);
        btnCredencial.setForeground(new Color(255, 255, 255));
        btnCredencial.setBackground(new Color(0, 0, 0));
        btnCredencial.setFont(new Font("Tw Cen MT", Font.BOLD, 18));

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ClientPanel.main(new String[0]);
            }
        });
        btnOk.setBounds(450, 419, 113, 21);
        panel_1.add(btnOk);
        btnOk.setForeground(new Color(255, 255, 255));
        btnOk.setBackground(new Color(0, 0, 0));
        btnOk.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

        btnCredencial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Credential credentialWindow = new Credential();
                credentialWindow.getFrame().setVisible(true);
            }
        });
    }

    private void cargarDatosTabla(int clientId) {
        List<List<String>> classes = controller.getClientClasses(clientId);
        List<List<String>> payments = controller.getClientPayments(clientId);
        List<List<String>> attendances = controller.getClientAttendance(clientId);

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Clase", "Pagos", "Asistencia"}, 0);

        int maxSize = Math.max(classes.size(), Math.max(payments.size(), attendances.size()));

        for (int i = 0; i < maxSize; i++) {
            String clase = i < classes.size() ? classes.get(i).get(0) : "";
            String pago = i < payments.size() ? payments.get(i).get(0) : "";
            String asistencia = i < attendances.size() ? attendances.get(i).get(0) : "";
            model.addRow(new Object[]{clase, pago, asistencia});
        }

        table.setModel(model);
    }

    public void show() {
        frame.setVisible(true);
    }
}
