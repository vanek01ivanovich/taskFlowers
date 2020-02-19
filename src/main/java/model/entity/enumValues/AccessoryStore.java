package model.entity.enumValues;

import view.View;

public enum AccessoryStore {
    RIBBON(12,"Стрічка",0),
    WRAPPER(20,"Обгортка",1),
    NOTE(15,"Записка",2),
    STICKS(5,"Палочка",3);

    private final int key;
    private final int price;
    private final String ukrName;

    public String ukrName(){
        return ukrName;
    }
    public int price(){
        return price;
    }
    public int key(){return key;}

    AccessoryStore(int price,String ukrName,int key){
        this.price = price;
        this.ukrName = ukrName;
        this.key = key;
    }

    @Override
    public String toString(){
        String lang = (View.resourceBundle.getLocale().toString()).equals("ua") ?
                AccessoryStore.this.ukrName : AccessoryStore.this.name();
        return "\t" + lang;
    }
}
