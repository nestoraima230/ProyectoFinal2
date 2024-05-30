package instructorsControllers;

import java.util.List;
import instructorsModels.ConsultRecordModel;

public class ConsultRecordsController {
    private ConsultRecordModel model;

    public ConsultRecordsController() {
        model = new ConsultRecordModel();
    }

    public List<String> getInstructorDetails(int instructorId) {
        return model.getInstructorDetails(instructorId);
    }

    public List<List<String>> getAllInstructors() {
        return model.getAllInstructors();
    }
}
