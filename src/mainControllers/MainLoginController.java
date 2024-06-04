package mainControllers;

import mainModel.MainLoginModel;

public class MainLoginController {
    private MainLoginModel mainLoginModel;

    public MainLoginController() {
        mainLoginModel = new MainLoginModel();
    }

    public boolean login(String username, String password) {
        return mainLoginModel.login(username, password);
    }
}
