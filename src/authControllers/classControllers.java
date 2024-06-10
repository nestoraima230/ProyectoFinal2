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

    public boolean updateClase(String nombre,  Timestamp horario, Time duracion, int instructorId, int capacidadMaxima, int claseid){
        return classModels.updateClase(nombre, horario, duracion, instructorId, capacidadMaxima, claseid);
    }
    
    public String getNombreInstructor(int instructorId) {
    	return classModels.getNombreInstructor(instructorId);
    	
    }
    
    public List<List<String>> getInstructorsForClass(int classId) {
        return classModels.getInstructorsForClass(classId);
    }

    
    public List<String> getDetallesClase(int classId) {
        return classModels.getDetallesClase(classId);
    }


    public boolean deleteClase(int ID) {
        return classModels.deleteClase(ID);
    }
}
