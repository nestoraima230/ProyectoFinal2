package mainControllers;

import mainModel.MainRegisterModel;

public class MainRegisterController {
    private MainRegisterModel registerModel;

    public MainRegisterController() {
        this.registerModel = new MainRegisterModel();
    }

    public boolean registerUser(String username, String password, String email) {
        return registerModel.registerUser(username, password, email);
    }

	public static boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
