package View;

import Controller.Controller;
import model.Worker;
import Controller.OpenNewDealController;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCLIView implements View, Runnable{

    private Scanner input; //gets a system.in in driver to get a user input
    private PrintWriter output; //gets an system.out in driver to write to console
    private OpenNewDealController openDealController; //not sure this is the controller needed

    public MyCLIView(InputStream in, OutputStream out) {
        this.input = new Scanner(in);
        this.output = new PrintWriter(out);
    }

    @Override
    public void start() {
        new Thread(this).start();
    }

    @Override
    public void setOpenDealController(OpenNewDealController controller) {
        this.openDealController = controller;
    }

    @Override
    public void run() {
        this.write("Welcome");
        this.write("Please choose what would you like to do:");
        this.write("press 1 : to start a new Shift");
        this.write("press 2 : to start a new Deal");
        this.write("press 3 : to close a shift");//here deals can be sorted by amount for daily report
        this.write("press 4 : to watch monthly report");
        //here deals will be sorted by date, maybe only manager can access
        int choice = 0;

        while(true){

            choice = this.input.nextInt();
            switch (choice){
                case 1 :
                {

                    //controler.startShift()
                    //here a shift constructor is called
                    //in shift should check if current date in shift is equal to todays date
                    //if not, reading again all files, initialize workers and deals array
                    //controller should return a boolean
                    boolean isAlreadyOpen = false;
                    if (isAlreadyOpen){
                        this.write("shift already open today");
                    }else{
                        this.write("shift opened successfully");
                    }
                    break;
                }

                case 2 :
                {
                    try {
                        openDealController.OpenNewDeal();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    write("Deal was done successfuly!");
                    //call controller method to open new deal controller.openNewDeal()
                    //controller will call 3 view methodes for this:
                    // enteringItems()
                    // addingPayment()
                    // addingHelpingWorker()
                    break;
                }

                case 3 :
                {
                    //calling controller method of closing shift
                    //getting reports from controller
                    this.write("press 1 to watch daily report");
                    break;
                }
                case 4 :
                {
                   this.write("monthly report");
                   //call controller method for monthly report
                    break;
                }

                default: {
                    this.write("please enter a valid value");
                    //do nothing?
                }
            }
        }
    }

    public void write(String str){
        this.output.println(str);
        this.output.flush();

    }

    public void enteringItems(){
        this.write("please enter items barcode to stop enter -1 ");
        int barcode = this.input.nextInt();
        while ( barcode != -1){
            //call method in controller that try to add item
            boolean itemExists = this.openDealController.addItem(barcode);
            if (itemExists){
                this.write("item add successfully");
            } else{
                this.write("No such item in stock");
            }
            barcode = this.input.nextInt();
            //another controller method : controller.addItem(int id) returns a boolean
            //controller returns wether item exists in items list (file) or not
            //if exists call method in model to add it to deal
        }
    }

    public void addingPayment(){
        this.write("Now add payment method");
        this.write("press 1 for 'cash' or 2 for 'credit card':");
        String paymentType;
        int choice = this.input.nextInt();
        while (choice !=1 && choice != 2){
            this.write("not a valid value: press 1 for 'cash' or 2 for 'credit card':");
            choice = this.input.nextInt();
        }

        if(choice == 1){
            paymentType = "cash";
        } else{
            paymentType = "credit card";
        }

        this.write("now enter amount of money paid");
        int paymentAmount = this.input.nextInt();
        openDealController.addNewPayment(paymentType, paymentAmount);
        //here method of controller.addPayment();

    }

    public void addingHelpingWorker(){
        this.write("please choose a helping worker name");
        //get from controller list of workers in current shift controller.getWorkersList
        List<Worker> workers = openDealController.getWorkersList();
        int i = 0;
        for (Worker worker: workers){
            this.write("enter " + i + " for " + worker.getName());
            i++;
        }

        int workerChoice = (int)this.input.nextInt();
        while (workerChoice >= workers.size() || workerChoice < 0){
            this.write("not a valid choice");
            workerChoice = this.input.nextInt();
        }

        Worker helpingWorker = workers.get(workerChoice);
        openDealController.addHelpingWorker(helpingWorker);
        //controller method to add chosen worker to deal controller.addHelpingWorker();
    }
}
