package instructorsControllers;

import instructorsModels.EditInstructorModel;
import instructorsViews.InstructorEdit;
import instructorsViews.InstructorPanel;


public class EditInstructorController {

    private EditInstructorModel model;
    private InstructorEdit view;
    private InstructorPanel instructorPanel;


    public EditInstructorController() {
        model = new EditInstructorModel();
        instructorPanel = new InstructorPanel();

    }

    public boolean updateInstructor(int id, String nombre, String apellidos, String especialidad, String email) {
        return model.updateInstructor(id, nombre, apellidos, especialidad, email);
    }

    public boolean deleteInstructor(int id) {
        return model.deleteInstructor(id);
    }

    public void showView(int instructorId) {
        view = new InstructorEdit(this, instructorId);
        view.setVisible(true);
    }

    public InstructorEdit getView() {
        return view;
    }
}
