package controller;

import model.entity.enumValues.AccessoryStore;
import model.entity.enumValues.FlowerStore;
import model.entity.enumValues.Functions;
import view.View;

import java.util.Scanner;

public class CheckStaff {
    private String input;
    private View view;


    /**
     * Constructor of class CheckStaff
     * @param scanner
     * @param view
     */
    public CheckStaff(Scanner scanner, View view) {
        this.view = view;
    }

    /**
     * Method of checking if number is right
     * @param scanner
     * @return int value of number of staff
     */
    public int checkValueForStaff(Scanner scanner){
        while (!(scanner.hasNext() && (input = scanner.nextLine()).matches("[1-9]|[1-9][0-9]+"))){
                //&& valueIsInStaff(input))){
            view.printBundle(View.INPUT_WRONG);
        }

        return Integer.parseInt(input);
    }

    /**
     * Method of checking if number is right
     * @param scanner
     * @param textBundle
     * @return int value of number of staff
     */
    int checkValueForStaff(Scanner scanner, String textBundle){
        while (!(scanner.hasNext() && (input = scanner.nextLine()).matches("[0-9]+")
                && valueIsInStaff(input))){
            view.printBundle(View.INPUT_WRONG,textBundle);
        }

        return Integer.parseInt(input);
    }

    /**
     * Method of checking if number is right
     * @param scanner
     * @param numb
     * @return int value of number of staff
     */
    int checkValueForStaff(Scanner scanner, int numb){
        while (!(scanner.hasNext() && (input = scanner.nextLine()).matches("[1-9]|[1-9][0-9]+") &&
                (Integer.parseInt(input) <= numb))){
                //&& valueIsInStaff(input))){
            view.printBundle(View.INPUT_WRONG);
            view.printBundle(View.INPUT_WRONG_ACCESSORIES, AccessoryStore.values().length,View.ACCESSORIES);
            view.printBundle(View.INPUT_CHOICE_ACCESSORIES);
        }

        return Integer.parseInt(input);
    }

    /**
     *Method of checking if value is in class
     * @param text
     * @return boolean value if function is exist
     */
    private boolean valueIsInStaff(String text){
        for (Functions func: Functions.values()) {
            if (Integer.parseInt(text) == func.ordinal()){
                return true;
            }
        }
        return false;
    }
}
