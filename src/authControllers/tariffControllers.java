package authControllers;

import authModels.tariffModels;
import java.util.List;

public class tariffControllers {
    private tariffModels tariffModels;

    public tariffControllers() {
        tariffModels = new tariffModels();
    }

    public boolean addTariff(int clienteId, java.sql.Date fechaValidaInicial, java.sql.Date fechaValidaFinal, double costo) {
        return tariffModels.addTariff(clienteId, fechaValidaInicial, fechaValidaFinal, costo);
    }

    public List<String> getTariff(int id) {
        return tariffModels.getTariff(id);
    }
    
    public String getNombreClient(int clientId) {
    	return tariffModels.getNombreClient(clientId);
    	
    }

    public List<List<String>> getAllTariffs() {
        return tariffModels.getAllTariffs();
    }

    public boolean updateTariff(int id, int clienteId, java.sql.Date fechaValidaInicial, java.sql.Date fechaValidaFinal, double costo, String nombre) {
        return tariffModels.updateTariff(id, clienteId, fechaValidaInicial, fechaValidaFinal, costo, nombre);
    }

    public boolean deleteTariff(int id) {
        return tariffModels.deleteTariff(id);
    }
}

