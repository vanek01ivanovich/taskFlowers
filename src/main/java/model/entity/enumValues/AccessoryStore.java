package model.entity.enumValues;

import view.View;
/**
 * Enum class AccessoryStore
 * @author Ivan
 * @version 1.0
 */
public enum AccessoryStore {
    RIBBON(12,"Стрічка"),
    WRAPPER(20,"Обгортка"),
    NOTE(15,"Записка"),
    STICKS(5,"Палочка");

    private final int price;
    private final String ukrName;

    public String ukrName(){
        return ukrName;
    }
    public int price(){
        return price;
    }

    AccessoryStore(int price,String ukrName){
        this.price = price;
        this.ukrName = ukrName;
    }

    @Override
    public String toString(){
        String lang = (View.resourceBundle.getLocale().toString()).equals("ua") ?
                AccessoryStore.this.ukrName : AccessoryStore.this.name();
        return "\t" + lang;
    }
}
