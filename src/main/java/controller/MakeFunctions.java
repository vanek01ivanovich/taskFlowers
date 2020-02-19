package controller;

import model.entity.Accessories;
import model.entity.Flowers;
import model.entity.Staff;
import model.entity.enumValues.AccessoryStore;
import model.entity.enumValues.FlowerStore;
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


    MakeFunctions(Scanner scanner, View view, CheckStaff checkStaff, ArrayList<Flowers> flowersInBouquet,
                  ArrayList<Accessories> accessoriesInBouquet) {
        this.scanner = scanner;
        this.view = view;
        this.accessoriesInBouquet = accessoriesInBouquet;
        this.checkStaff = checkStaff;
        this.flowersInBouquet = flowersInBouquet;
    }

    void functions() {
        view.printBundle(View.INPUT_FUNCTIONS);
        view.printFunctionsFromStore();

        do {
            view.printBundle(View.INPUT_NUMB_FUNCTION);
            chooseFunction();
        }while (checkIfContinue(scanner));


    }
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
    private void sortFreshness(){
        flowersInBouquet.sort(Comparator.comparingInt(Flowers::getFreshnessDays));
        //вынести в view
        for (Flowers fl: flowersInBouquet) {
            System.out.println(fl.getName() + " - " + fl.getFreshnessDays());
        }
    }

    private void findTrunk(Scanner scanner){
        view.printBundle(View.INPUT_MIN_RANGE_LENGTH);
        minLength = checkStaff.checkValueForStaff(scanner);
        view.printBundle(View.INPUT_MAX_RANGE_LENGTH);
        maxLength = checkStaff.checkValueForStaff(scanner);

        for (Flowers fl:flowersInBouquet) {
            if (fl.getTrunkLength() >= minLength && fl.getTrunkLength() <= maxLength){
                System.out.println(fl.getName() + " - " + fl.getTrunkLength());
            }
        }

    }

    private void countTotalPrice(){
        for (Flowers flowers: flowersInBouquet) {
            price += flowers.getPrice();
        }
        for (Accessories accessory: accessoriesInBouquet) {
            price += accessory.getPrice();
        }
        view.printBundle(View.OUTPUT_TOTAL_PRICE,price);
    }

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
