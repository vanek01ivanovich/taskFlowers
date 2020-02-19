package model.entity.enumValues;

import view.View;

public enum FlowerStore {
    ROSE("Роза",0,50,1,30),
    VIOLET("Фіалка",1,5,3,15),
    TULIP("Тюльпан",2,30,2,20),
    ORCHID("Орхідея",3,70,4,90),
    LILY("Лілія",4,8,1,45),
    PEONY("Піон",5,25,5,60),
    CHAMOMILE("Ромашка",6,16,7,20),
    ASTER("Астра",7,42,5,60),
    DAISY("Маргаритка",8,5,2,30);

    private final String ukrName;
    private final int trunkLength;
    private final int freshnessDays;
    private final int price;
    private final int key;
    //private int amount;


    /*public void setAmount(int numb){
        this.amount = amount;
    }*/

    //public int key(){return key;}
    public int trunkLength(){return trunkLength;}
    public int freshnessDays(){return freshnessDays;}
    public int price(){return price;}
    public String ukrName(){return ukrName;}

    private FlowerStore(String ukrName,int key,int trunkLength,int freshnessDays,int price){
        this.ukrName = ukrName;
        this.trunkLength = trunkLength;
        this.freshnessDays = freshnessDays;
        this.price = price;
        this.key = key;
        //this.amount = amount;
    }

    @Override
    public String toString(){
        String lang = (View.resourceBundle.getLocale().toString()).equals("ua") ?
                FlowerStore.this.ukrName : FlowerStore.this.name();
        return "\t" + lang + "-" + key;
    }


}
