package model.entity.enumValues;

import view.View;

public enum Functions {
    TOTAL_PRICE("Загальна ціна вашого букета",0),
    FLOWERS_SORT("Відсортувати квіти за свіжістю",1),
    FIND_TRUNK_LENGTH("Пошук квітки за довжиною",2);

    private final String ukrName;
    private final int key;
    private String lang;


    private Functions(String ukrName,int key){
        this.ukrName = ukrName;
        this.key = key;
    }

    @Override
    public String toString(){
        lang = (View.resourceBundle.getLocale().toString()).equals("ua") ?
                Functions.this.ukrName : Functions.this.name();
        return "\t" + lang + "-" + key;
    }
}
