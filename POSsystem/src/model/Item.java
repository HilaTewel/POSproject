public class Item extends ProductSpecification {
    private static int BarcodeCounter = 0;
    private int Barcode;

    public Item(String name, int ID, float price, int colorCode) {
        super(name, ID, price, colorCode);
        Item.updateCounter();
        this.Barcode = Item.BarcodeCounter;
    }

    private static void updateCounter(){
        Item.BarcodeCounter++;
    }

    public int getBarcode() {
        return this.Barcode;
    }

    public void setBarcode(final int barcode) {
        this.Barcode = barcode;
    }
}
