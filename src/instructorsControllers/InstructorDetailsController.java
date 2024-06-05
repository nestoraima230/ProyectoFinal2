package instructorsControllers;

import java.util.List;
import instructorsModels.InstructorDetailsModel;
import instructorsViews.InstructorReportcard;
import instructorsViews.InstructorCredential;

public class InstructorDetailsController {
	
    private InstructorDetailsModel model;
    private InstructorReportcard InstructorReportcard;
    private InstructorCredential InstructorCredential;
    
    public InstructorDetailsController() {
        model = new InstructorDetailsModel();
        InstructorReportcard = new InstructorReportcard();
        InstructorCredential = new InstructorCredential();

    }

    public List<String> getInstructorSpecialties() {
        return model.getInstructorSpecialties();
    }
}
