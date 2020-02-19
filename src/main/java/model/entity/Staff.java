package model.entity;

public class Staff {

    String name;
    private int price;


    Staff(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() { return name; }

}
