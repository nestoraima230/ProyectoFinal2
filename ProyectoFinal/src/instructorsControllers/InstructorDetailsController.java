package instructorsControllers;

import java.util.List;
import instructorsModels.InstructorDetailsModel;
import instructorsViews.InstructorPanel;
import instructorsViews.InstructorReportcard;
import instructorsViews.InstructorCredential;

public class InstructorDetailsController {
	
    private InstructorDetailsModel model;
    private InstructorPanel instructorPanel;
    private InstructorReportcard InstructorReportcard;
    private InstructorCredential InstructorCredential;
    
    public InstructorDetailsController() {
        model = new InstructorDetailsModel();
        instructorPanel = new InstructorPanel();
        InstructorReportcard = new InstructorReportcard();
        InstructorCredential = new InstructorCredential();

    }

    public List<String> getInstructorSpecialties() {
        return model.getInstructorSpecialties();
    }
}
