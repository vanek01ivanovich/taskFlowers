package model.entity;

import model.entity.enumValues.AccessoryStore;
import view.View;

public class Accessories extends Staff {


    public Accessories(AccessoryStore accessory) {
        super(accessory.name(),accessory.price());
    }

    @Override
    public String getName(){
        return (View.resourceBundle.getLocale().toString()).equals("ua") ?
                AccessoryStore.valueOf(name).ukrName() : name;
    }
    @Override
    public int getPrice(){
        return super.getPrice();
    }
}
