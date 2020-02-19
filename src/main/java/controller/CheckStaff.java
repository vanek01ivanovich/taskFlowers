package controller;

import model.entity.enumValues.FlowerStore;
import model.entity.enumValues.Functions;
import view.View;

import java.util.Scanner;

class CheckStaff {
    private Scanner scanner;
    private String input;
    private View view;


    CheckStaff(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    int checkValueForStaff(Scanner scanner){
        while (!(scanner.hasNext() && (input = scanner.nextLine()).matches("[0-9]+"))){
                //&& valueIsInStaff(input))){
            view.printBundle(View.INPUT_WRONG);
        }

        return Integer.parseInt(input);
    }

    int checkValueForStaff(Scanner scanner, String textBundle){
        while (!(scanner.hasNext() && (input = scanner.nextLine()).matches("[0-9]+")
                && valueIsInStaff(input))){
            view.printBundle(View.INPUT_WRONG,textBundle);
        }

        return Integer.parseInt(input);
    }
    int checkValueForStaff(Scanner scanner, int numb){
        while (!(scanner.hasNext() && (input = scanner.nextLine()).matches("[0-9]+") &&
                (Integer.parseInt(input) <= numb))){
                //&& valueIsInStaff(input))){
            view.printBundle(View.INPUT_WRONG,View.INPUT_WRONG_ACCESSORIES,View.INPUT_CHOICE_ACCESSORIES);
        }

        return Integer.parseInt(input);
    }

    private boolean valueIsInStaff(String text){
        for (Functions func: Functions.values()) {
            if (Integer.parseInt(text) == func.ordinal()){
                return true;
            }
        }
        return false;
    }
}
