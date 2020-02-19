package view;

import model.entity.enumValues.AccessoryStore;
import model.entity.enumValues.FlowerStore;
import model.entity.enumValues.Functions;

import java.util.Locale;
import java.util.ResourceBundle;

public class View implements TextConstants {
    public static ResourceBundle resourceBundle;

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printBundle(String... message){
        for (String mes: message) {
            System.out.println(resourceBundle.getString(mes));
        }
    }
    public void printBundle(String message,int value){
        System.out.println(resourceBundle.getString(message).concat(String.valueOf(value)));
    }

    public void languageChoice(int valueForChoiceLanguage){
        if (valueForChoiceLanguage == 1){
            resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME,new Locale("ua"));
        }else {
            resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME,Locale.ENGLISH);
        }
    }
    public void printFlowersFromStore(){
        for (FlowerStore flowers: FlowerStore.values()) {
            System.out.println(flowers);
        }
    }
    public void printAccessoriesFromStore(){
        for (AccessoryStore accessoryStore: AccessoryStore.values()) {
            System.out.println(accessoryStore);
        }
    }

    public void printFunctionsFromStore(){
        for (Functions func: Functions.values()) {
            System.out.println(func);
        }
    }



}
