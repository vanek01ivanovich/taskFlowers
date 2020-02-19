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

    public void printMessage(String... message){
        for (String mes: message) {
            System.out.print(mes);
        }
        System.out.println();
    }

    public void printBundle(String... message){
        for (String mes: message) {
            System.out.println(resourceBundle.getString(mes));
        }
    }
    public void printBundle(String message,int value,String mes){
        System.out.println(resourceBundle.getString(message).concat(String.valueOf(value)).concat(" ").concat(resourceBundle.getString(mes)));
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


    public void printStaffFromStore(Class<?> cls){
        if (cls == FlowerStore.class){
            for (FlowerStore flowers: FlowerStore.values()) {
                System.out.println(flowers + " - " + flowers.price() + "$");
            }
        }else if (cls == AccessoryStore.class){
            for (AccessoryStore accessoryStore: AccessoryStore.values()) {
                System.out.println(accessoryStore + " - " + accessoryStore.price() + "$");
            }
        }else if (cls == Functions.class){
            for (Functions func: Functions.values()) {
                System.out.println(func);
            }
        }

    }





}
