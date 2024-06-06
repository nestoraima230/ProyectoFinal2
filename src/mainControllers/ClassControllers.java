package mainControllers;

import classView.ClassPanel;
import classView.ClassRecords;
import classView.Classes;
import classView.ClassCreate;
import classView.ClassDetail;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassControllers {

    private ClassPanel classPanel;
    private ClassRecords classRecords;
    private Classes classes;
    private ClassDetail classDetail;
    private ClassCreate classCreate;

    public ClassControllers() {
        this.classPanel = new ClassPanel();
        this.classRecords = new ClassRecords();
        this.classes = new Classes();
        this.classDetail = new ClassDetail();
        this.classCreate = new ClassCreate();

        
        classPanel.getBtnMostrarRecords().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVistaRecords();
            }
        });

        classPanel.getBtnMostrarClasses().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVistaClasses();
            }
        });

        classRecords.getBtnMostrarDetalle().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVistaDetail();
            }
        });

        classes.getBtnCrearClase().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVistaCreate();
            }
        });

        classCreate.getBtnGuardar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            }
        });
    }

    public void mostrarVistaPanel() {
        classPanel.getFrame().setVisible(true);
    }

    public void mostrarVistaRecords() {
        classRecords.getFrame().setVisible(true);
    }

    public void mostrarVistaClasses() {
        classes.getFrame().setVisible(true);
    }

    public void mostrarVistaDetail() {
        classDetail.getFrame().setVisible(true);
    }

    public void mostrarVistaCreate() {
        ClassCreate.getFrame().setVisible(true);
    }
}
