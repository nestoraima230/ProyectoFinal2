package authControllers;

import java.util.List;

import authModels.clientModels;

public class clientControllers {
    private clientModels clientModels;
    private int selectedClientId;

    public clientControllers() {
        clientModels = new clientModels();
    }

    public boolean addClient(List<String> client) {
        return clientModels.addClient(client);
    }

    public List<String> getClientDetails(int clientId) {
        return clientModels.getClientDetails(clientId);
    }

    public List<List<String>> getAllClients() {
        return clientModels.getAllClients();
    }

    
    public List<List<String>> getClientClasses(int clientId) {
        return clientModels.getClientClasses(clientId);
    }

    public List<List<String>> getClientPayments(int clientId) {
        return clientModels.getClientPayments(clientId);
    }

    public List<List<String>> getClientAttendance(int clientId) {
        return clientModels.getClientAttendances(clientId);
    }
    
    public boolean deleteClient(int id) {
        return clientModels.deleteClient(id);
    }

    public boolean updateClient(int clientId, List<String> newClientDetails) {
        return clientModels.updateClient(clientId, newClientDetails);
    }


    public boolean generarPDFCredencialCliente(List<String> clienteDetails, String logoPath, String clienteImagePath, String filePath) {
        return clientModels.generarPDFCredencialCliente(clienteDetails, logoPath, clienteImagePath, filePath);
    }

    public boolean generarPDFReporteCliente(List<String> clienteDetails, List<String> reportDetails, String filePath) {
        return clientModels.generarPDFReporteCliente(clienteDetails, reportDetails, filePath);
    }
    public void setSelectedClientId(int clientId) {
        this.selectedClientId = clientId;
    }

    public int getSelectedClientId() {
        return selectedClientId;
    }
    
    
    public int buscarIdCliente(String nombre, String apellidos, String fechaNacimiento, String telefono) {
        List<List<String>> allClients = clientModels.getAllClients();

        for (List<String> clientDetails : allClients) {
            if (clientDetails.get(0).equals(nombre) &&
                clientDetails.get(1).equals(apellidos) &&
                clientDetails.get(2).equals(telefono) &&
                clientDetails.get(3).equals(fechaNacimiento)) {
                return allClients.indexOf(clientDetails) + 1;
            }
        }

        return -1;
    }


}
