package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private ArrayList<Item> itemsInStock;

    public Stock() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("itemsInStock");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        this.itemsInStock = (ArrayList<Item>) objectInputStream.readObject();
        objectInputStream.close();
    }

    public boolean isItemInStock(int barcode){//check if exist in stock
        for (Item item:itemsInStock){
            if (item.getBarcode() == barcode){
                return true;
            }
        }
        return false;
    }

    public Item removeItem(int barcode){//remove from list
        Item itemToReturn = null;
        for (Item item : itemsInStock){

            if (item.getBarcode() == barcode){
                 itemToReturn= item;
                itemsInStock.remove(item);
            }
        }
        return itemToReturn;
    }

    public void writeChangesToFile() throws IOException {//updating stock file
        FileOutputStream fileOutputStream = new FileOutputStream("itemsInStock");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(itemsInStock);
        objectOutputStream.close();
    }
}
