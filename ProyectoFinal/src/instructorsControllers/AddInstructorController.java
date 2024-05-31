package instructorsControllers;

import java.util.List;
import instructorsModels.AddInstructorModel;
import instructorsViews.InstructorCreate;
import instructorsViews.InstructorPanel;

public class AddInstructorController {
    private InstructorCreate view;
    private AddInstructorModel model;
    private InstructorPanel instructorPanel;
    

    public AddInstructorController() {
        model = new AddInstructorModel();
        view = new InstructorCreate(this);  
        instructorPanel = new InstructorPanel();
        
    }

    public boolean addInstructor(String nombre, String apellidos, String especialidad, String email) {
        List<String> instructorData = List.of(nombre, apellidos, especialidad, email);
        return model.addInstructor(instructorData);
    }
    
    public InstructorCreate getView() {
        return view;
        
    }
}
