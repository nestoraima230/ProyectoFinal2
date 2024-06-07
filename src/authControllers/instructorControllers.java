package authControllers;

import authModels.instructorModels;
import java.util.List;

public class instructorControllers {
    private instructorModels instructorModels;

    public instructorControllers() {
        instructorModels = new instructorModels();
    }

    public boolean addInstructor(List<String> instructor) {
        return instructorModels.addInstructor(instructor);
    }

    public List<String> getInstructorDetails(int instructorId) {
        return instructorModels.getInstructorDetails(instructorId);
    }

    public List<List<String>> getAllInstructors() {
        return instructorModels.getAllInstructors();
    }

    public boolean updateInstructor(int id, String nombre, String apellidos, String especialidad, String email) {
        return instructorModels.updateInstructor(id, nombre, apellidos, especialidad, email);
    }

    public boolean deleteInstructor(int id) {
        return instructorModels.deleteInstructor(id);
    }

    public List<List<String>> getAllInstructorsClassHistory() {
        return instructorModels.getAllInstructorsClassHistory();
    }
    
    public List<String> getInstructorSpecialties() {
        return instructorModels.getInstructorSpecialties();
    }

    public boolean generateCredentialPDF(List<String> instructorDetails, String filePath) {
        return instructorModels.generateCredentialPDF(instructorDetails, filePath);
    }

    public boolean generateReportPDF(List<List<String>> data, String filePath) {
        return instructorModels.generateReportPDF(data, filePath);
    }
}
