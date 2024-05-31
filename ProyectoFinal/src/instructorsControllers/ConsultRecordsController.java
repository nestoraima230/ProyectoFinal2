package instructorsControllers;

import java.util.List;
import instructorsModels.ConsultRecordModel;
import instructorsViews.InstructorPanel;

public class ConsultRecordsController {
    private ConsultRecordModel model;
    private InstructorPanel instructorPanel;


    public ConsultRecordsController() {
        model = new ConsultRecordModel();
        instructorPanel = new InstructorPanel();
    }

    public List<String> getInstructorDetails(int instructorId) {
        return model.getInstructorDetails(instructorId);
    }

    public List<List<String>> getAllInstructors() {
        return model.getAllInstructors();
    }
}
