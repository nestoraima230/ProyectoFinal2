package authControllers;

import authModels.mainModels;

public class mainControllers {
    private mainModels mainModels;

    public mainControllers() {
        mainModels = new mainModels();
    }

    public boolean login(String username, String password) {
        return mainModels.login(username, password);
    }

    public boolean registerUser(String username, String password, String email) {
        return mainModels.registerUser(username, password, email);
    }
}
