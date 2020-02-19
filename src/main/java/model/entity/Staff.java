package model.entity;



public class Staff {

    public String name;
    private int price;
    private int amount;
    //private String langName;

    //public Staff(){}

    public Staff(String name,int price){
        this.name = name;
        this.price = price;
    }

    /*public Staff(String name,int price,int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }*/

    public int getPrice() {
        return price;
    }

    /*public void setPrice(int price) {
        this.price = price;
    }*/

    public String getName() {

        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

}
