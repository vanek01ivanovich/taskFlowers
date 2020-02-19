package model.entity;

import model.entity.enumValues.FlowerStore;
import view.View;

public class Flowers extends Staff {

    private int key;
    private int trunkLength;
    private int freshnessDays;


    public Flowers(FlowerStore flower){
        super(flower.name(),flower.price());

        setTrunkLength(flower.trunkLength());
        //setPrice(flower.price());
        setFreshnessDays(flower.freshnessDays());

    }

    @Override
    public int getPrice(){
       return super.getPrice();
    }

    public int getTrunkLength() {
        return trunkLength;
    }

    public void setTrunkLength(int trunkLength) {
        this.trunkLength = trunkLength;
    }

    public int getFreshnessDays() {
        return freshnessDays;
    }

    public void setFreshnessDays(int freshnessDays) {
        this.freshnessDays = freshnessDays;
    }

    @Override
    public String getName() {
        return (View.resourceBundle.getLocale().toString()).equals("ua") ?
                FlowerStore.valueOf(name).ukrName() : name;
    }
}
