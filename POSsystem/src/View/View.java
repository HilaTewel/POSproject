package View;

import Controller.Controller;
import Controller.OpenNewDealController;

public interface View {

    void start();
    void setOpenDealController(OpenNewDealController controller);
    void addingPayment();
    void addingHelpingWorker();
    public void enteringItems();

}
