package mainControllers;
import clientView.ClientPanel;
import clientView.ClientReport;
import clientView.Credential;
import clientView.EditClient;
import clientView.NewClient;
import clientView.UploadPhoto;

	public class Controller implements ControllerInterface {
    private ClientPanel clientPanel;
    private ClientReport clientReport;
    private Credential credential;
    private EditClient editClient;
    private NewClient newClient;
    private UploadPhoto uploadPhoto;

    public Controller() {
        
        clientPanel = new ClientPanel();
        clientReport = new ClientReport();
        credential = new Credential();
        editClient = new EditClient();
        newClient = new NewClient();
        uploadPhoto = new UploadPhoto();
    }

   
    public void showClientPanel() {
        clientPanel.show();
    }

    public void showClientReport() {
        clientReport.show();
    }

    public void showCredential() {
        credential.show();
    }

    public void showEditClient() {
        editClient.show();
    }

    public void showNewClient() {
        newClient.show();
    }

    public void showUploadPhoto() {
        uploadPhoto.show();
    }
}
