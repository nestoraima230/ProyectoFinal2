package authControllers;

import java.sql.Time;
import java.util.List;

import authModels.classModels;

public class classControllers {
    private classModels classModels;

    public classControllers() {
        classModels = new classModels();
    }

    public boolean addClase(String nombre, String tipoClase, String descripcion, String nivelDificultad, 
                            java.sql.Date fechaInicio, java.sql.Date fechaFin, Time duracion, 
                            int instructorId, int capacidadMaxima) {
        return classModels.addClase(nombre, tipoClase, descripcion, nivelDificultad, fechaInicio, fechaFin, duracion, instructorId, capacidadMaxima);
    }

    public List<String> getClase(int id) {
        return classModels.getClase(id);
    }

    public List<List<String>> getAllClases() {
        return classModels.getAllClases();
    }

    public boolean updateClase(int id, String nombre, String tipoClase, String descripcion, String nivelDificultad, 
                               java.sql.Date fechaInicio, java.sql.Date fechaFin, Time duracion, 
                               int instructorId, int capacidadMaxima) {
        return classModels.updateClase(id, nombre, tipoClase, descripcion, nivelDificultad, fechaInicio, fechaFin, duracion, instructorId, capacidadMaxima);
    }

    public boolean deleteClase(int id) {
        return classModels.deleteClase(id);
    }
}
