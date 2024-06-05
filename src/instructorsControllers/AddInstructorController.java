package instructorsControllers;

import java.util.List;
import instructorsModels.AddInstructorModel;
import instructorsViews.InstructorCreate;


public class AddInstructorController {
    private InstructorCreate view;
    private AddInstructorModel model;

    

    public AddInstructorController() {
        model = new AddInstructorModel();
        view = new InstructorCreate(this);  

        
    }

    public boolean addInstructor(String nombre, String apellidos, String especialidad, String email) {
        List<String> instructorData = List.of(nombre, apellidos, especialidad, email);
        return model.addInstructor(instructorData);
    }
    
    public InstructorCreate getView() {
        return view;
        
    }
}
