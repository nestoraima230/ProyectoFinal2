package authControllers;

import authModels.tariffModels;
import java.sql.Date;
import java.util.List;

public class tariffControllers {
    private tariffModels tariffModels;

    public tariffControllers() {
        tariffModels = new tariffModels();
    }

    public boolean addTariff(int clienteId, Date fechaValidaInicial, Date fechaValidaFinal) {
        return tariffModels.addTariff(clienteId, fechaValidaInicial, fechaValidaFinal);
    }

    public List<String> getTariff(int id) {
        return tariffModels.getTariff(id);
    }

    public List<List<String>> getAllTariffs() {
        return tariffModels.getAllTariffs();
    }

    public boolean updateTariff(int id, int clienteId, Date fechaValidaInicial, Date fechaValidaFinal) {
        return tariffModels.updateTariff(id, clienteId, fechaValidaInicial, fechaValidaFinal);
    }

    public boolean deleteTariff(int id) {
        return tariffModels.deleteTariff(id);
    }
}
