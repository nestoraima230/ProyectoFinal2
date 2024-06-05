package authControllers;

import java.util.List;

import authModels.clientModels;

public class clientControllers {
    private clientModels clientModels;

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

    public boolean deleteClient(int id) {
        return clientModels.deleteClient(id);
    }

    public boolean generarPDFCredencialCliente(List<String> clienteDetails, String logoPath, String clienteImagePath, String filePath) {
        return clientModels.generarPDFCredencialCliente(clienteDetails, logoPath, clienteImagePath, filePath);
    }

    public boolean generarPDFReporteCliente(List<String> clienteDetails, List<String> reportDetails, String filePath) {
        return clientModels.generarPDFReporteCliente(clienteDetails, reportDetails, filePath);
    }
}
