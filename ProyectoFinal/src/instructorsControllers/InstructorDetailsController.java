package instructorsControllers;

import java.util.List;
import instructorsModels.InstructorDetailsModel;

public class InstructorDetailsController {
    private InstructorDetailsModel model;

    public InstructorDetailsController() {
        model = new InstructorDetailsModel();
    }

    public List<String> getInstructorSpecialties() {
        return model.getInstructorSpecialties();
    }
}
