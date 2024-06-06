package authControllers;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import authModels.classModels;

public class classControllers {
    private classModels classModels;

    public classControllers() {
        classModels = new classModels();
    }

    public boolean addClase(String nombre, Timestamp horario, Time duracion, int instructorId, int capacidadMaxima) {
        return classModels.addClase(nombre, horario, duracion, instructorId, capacidadMaxima);
    }


    public List<String> getClase(int ID) {
        return classModels.getClase(ID);
    }

    public List<List<String>> getAllClases() {
        return classModels.getAllClases();
    }

    public boolean updateClase(String nombre,  Timestamp horario, Time duracion, int instructorId, int capacidadMaxima, Timestamp nuevaHora){
    	return classModels.updateClase(nombre, horario, duracion, instructorId, capacidadMaxima);
    }
    
    public List<String> getDetallesClase(String nombreClase) {
        return classModels.getDetallesClase(nombreClase);
    }


    public boolean deleteClase(int ID) {
        return classModels.deleteClase(ID);
    }
}
