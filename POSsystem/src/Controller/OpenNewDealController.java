package Controller;

import View.View;
import model.*;

import java.io.IOException;
import java.util.ArrayList;

public class OpenNewDealController implements Controller{

    Shift shift;
    View view;
    private Deal deal;
    private Stock stock;


    public OpenNewDealController(View view) throws IOException, ClassNotFoundException {
        this.view = view;
        shift = Shift.getShift();
        stock = new Stock();
    }

    public void OpenNewDeal() throws IOException {
        deal = new Deal();
        view.enteringItems();
        view.addingPayment();
        view.addingHelpingWorker();
        shift.add_deal(deal);
        stock.writeChangesToFile();
    }

    public boolean addItem(int barcode){
        if (!stock.isItemInStock(barcode)){
            return false;
        } else{
            Item item = stock.removeItem(barcode);
            deal.addItem(item);
            return true;
        }
    }

    public void addNewPayment(String type, float amount){
        Payment payment = new Payment(type, amount);
        deal.setPayment(payment);
    }

    public ArrayList<Worker> getWorkersList(){
        //shift.getshiftworkers
        //return this arrayList
        return null;
    }

    public void addHelpingWorker(Worker worker){
        deal.setWorkerHelping(worker);
    }
}
