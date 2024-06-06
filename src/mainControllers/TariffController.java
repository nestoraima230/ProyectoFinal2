package mainControllers;

import tariffView.TariffCreate;
import tariffView.TariffDetail;
import tariffView.TariffPanel;

public class TariffController implements ControllerInterface {
    private TariffPanel tariffPanel;
    private TariffDetail tariffDetail;
    private TariffCreate tariffCreate;

    public TariffController() {
        tariffPanel = new TariffPanel();
        tariffDetail = new TariffDetail();
        tariffCreate = new TariffCreate();
    }

    @Override
    public void showClientPanel() {
        tariffPanel.show();
    }

    @Override
    public void showClientReport() {
        tariffDetail.show();
    }

    @Override
    public void showCredential() {
        tariffCreate.show();
    }

    @Override
    public void showEditClient() {
        // Método no implementado
    }

    @Override
    public void showNewClient() {
        // Método no implementado
    }

    @Override
    public void showUploadPhoto() {
        // Método no implementado
    }

    public interface ControllerInterface {
        void showClientPanel();
        void showClientReport();
        void showCredential();
        void showEditClient();
        void showNewClient();
        void showUploadPhoto();
    }
}
