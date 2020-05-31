package Driver;

import Controller.OpenNewDealController;
import View.View;
import View.MyCLIView;
import model.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class POSDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Shift shift = Shift.getShift();
        View view = new MyCLIView(System.in, System.out);
        OpenNewDealController OpenDealcontroller = new OpenNewDealController(view);

        view.setOpenDealController(OpenDealcontroller);
        view.start();

    }

    private static void initDB() throws IOException {
        FileOutputStream itemsFile = new FileOutputStream("itemsInStock");
        ObjectOutputStream itemsOOS = new ObjectOutputStream(itemsFile);
        List<Item> listOfItems = Arrays.asList(new Item[] { new Item("Skirt", (float) 200, 100),
        new Item ("Jeans", 200, 133), new Item("Shirt", 80, 170),
        new Item("Shoes", 300, 122), new Item("Dress", 200, 122),
                new Item ("Bag", 100, 166), new Item("Coat", 500, 189)});
        itemsOOS.writeObject(listOfItems);
        itemsOOS.close();

        FileOutputStream workersFile = new FileOutputStream("workers");
        ObjectOutputStream workersOOS = new ObjectOutputStream(workersFile);
        List<Worker> listOfWorkers = Arrays.asList(new Worker[] {new Seller("Hila", 11111), new Seller("Maya", 12132),
        new Seller("Sahar", 65337), new Seller("Inbal", 23453), new Manager("Adi", 98598, 112223),
        new Cashier("Danit", 28484), new Cashier("Mor", 46737), new Seller("Shelly", 23456)});
        workersOOS.writeObject(listOfWorkers);
        workersOOS.close();

    }
}
