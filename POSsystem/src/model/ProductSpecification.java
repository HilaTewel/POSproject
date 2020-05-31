package model;

abstract public class ProductSpecification {

    private static int IDcounter = 0;
    protected String name;
    protected int ID;
    protected float price;
    protected int colorCode;

     public ProductSpecification(final String name,  final float price, final int colorCode) {
         this.name = name;
         setID();
         this.price = price;
         this.colorCode = colorCode;
     }
     private static void updateCounter (){
         ProductSpecification.IDcounter++;
     }

     public String getName() {
         return this.name;
     }

     public void setName(final String name) {
         this.name = name;
     }

     public int getID() {
         return this.ID;
     }

     private void setID() {
         ProductSpecification.updateCounter();
         this.ID = ProductSpecification.IDcounter;
     }

     public float getPrice() {
         return this.price;
     }

     public void setPrice(final float price) {
         this.price = price;
     }

     public int getColorCode() {
         return this.colorCode;
     }

     public void setColorCode(final int colorCode) {
         this.colorCode = colorCode;
     }
 }
