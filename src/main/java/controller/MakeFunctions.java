package controller;

import model.entity.Accessories;
import model.entity.Flowers;
import model.entity.enumValues.Functions;
import view.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class MakeFunctions {

    private Scanner scanner;
    private View view;
    private CheckStaff checkStaff;
    private String input;
    private int minLength;
    private int maxLength;
    private int price;
    private ArrayList<Flowers> flowersInBouquet;
    private ArrayList<Accessories> accessoriesInBouquet;


    /**
     * Constructor
     * @param scanner,view,checkStaff,flowersInBouquet,accessoriesInBouquet signature for my constructor
     */
    MakeFunctions(Scanner scanner, View view, CheckStaff checkStaff, ArrayList<Flowers> flowersInBouquet,
                  ArrayList<Accessories> accessoriesInBouquet) {
        this.scanner = scanner;
        this.view = view;
        this.accessoriesInBouquet = accessoriesInBouquet;
        this.checkStaff = checkStaff;
        this.flowersInBouquet = flowersInBouquet;
    }

    /**
     * Method functions,main method of class MakeFunction
     */
    void functions() {
        view.printBundle(View.INPUT_FUNCTIONS);
        view.printStaffFromStore(Functions.class);

        do {
            view.printBundle(View.INPUT_NUMB_FUNCTION);
            chooseFunction();
        }while (checkIfContinue(scanner));


    }

    /**
     * Method of choosing functions
     */
    private void chooseFunction(){
        switch (checkStaff.checkValueForStaff(scanner,View.INPUT_FUNCTIONS)){
            case 0:
                countTotalPrice();
                break;
            case 1:
                sortFreshness();
                break;
            case 2:
                findTrunk(scanner);
                break;
        }
    }

    /**
     * Function of sorting flowers by freshness
     */
    private void sortFreshness(){
        flowersInBouquet.sort(Comparator.comparingInt(Flowers::getFreshnessDays));

        String days = (View.resourceBundle.getLocale().toString()).equals("ua") ? " днів": " days";
        for (Flowers fl: flowersInBouquet) {
            view.printMessage(fl.getName(), " - ",String.valueOf(fl.getFreshnessDays()),days);
        }
    }

    /**
     * Function of finding needed trunk`s
     * @param scanner
     */
    private void findTrunk(Scanner scanner){
        view.printBundle(View.INPUT_MIN_RANGE_LENGTH);
        minLength = checkStaff.checkValueForStaff(scanner);
        view.printBundle(View.INPUT_MAX_RANGE_LENGTH);
        maxLength = checkStaff.checkValueForStaff(scanner);

        for (Flowers fl:flowersInBouquet) {
            if (fl.getTrunkLength() >= minLength && fl.getTrunkLength() <= maxLength){
                view.printMessage(fl.getName()," - ",String.valueOf(fl.getTrunkLength()));
                return;
            }
        }

        view.printBundle(View.INPUT_WRONG_LENGTH);


    }

    /**
     * Function of counting total price
     */
    private void countTotalPrice(){
        for (Flowers flowers: flowersInBouquet) {
            price += flowers.getPrice();
        }
        for (Accessories accessory: accessoriesInBouquet) {
            price += accessory.getPrice();
        }
        view.printBundle(View.OUTPUT_TOTAL_PRICE,price);
    }


    /**
     * @param scanner User input if he/she wants to continue
     * @return boolean if user want to continue
     */
    private boolean checkIfContinue(Scanner scanner){
        view.printBundle(View.INPUT_CONTINUE);
        this.input = scanner.nextLine();
        while (!(input.equals("0") || input.equals("1"))){
            view.printBundle(View.INPUT_WRONG,View.INPUT_CONTINUE);
            input = scanner.nextLine();
        }

        return Integer.parseInt(input) != 0;
    }




}
