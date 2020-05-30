package model;

import model.Payment;
import model.Worker;

import javax.swing.plaf.IconUIResource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Deal {

    static int IDcounter = 0;
    private Payment payment;
    private float totalPrice;
    private int DealID;
    private LocalDateTime date;
    private Worker workerHelping;
    private List<Item> items;


    public Deal() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
        Deal.updateCounter();
        this.DealID = Deal.IDcounter;
        this.totalPrice = 0;
    }

    private static void updateCounter(){
        Deal.IDcounter++;
    }

    public void addItem (Item item){
        this.items.add(item);
        this.totalPrice += item.getPrice();
    }

    public void removeItem(Item item){
        this.items.remove(item);
        this.totalPrice -= item.getPrice();
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(final Payment payment) {
        this.payment = payment;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }

    public int getDealID() {
        return this.DealID;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Worker getWorkerHelping() {
        return this.workerHelping;
    }

    public void setWorkerHelping(final Worker workerHelping) {
        this.workerHelping = workerHelping;
    }

    public List<Item> getItems() {
        return this.items;
    }

}
