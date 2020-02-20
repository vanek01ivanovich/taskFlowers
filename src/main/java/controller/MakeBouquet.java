package controller;

import model.entity.*;
import model.entity.enumValues.AccessoryStore;
import model.entity.enumValues.FlowerStore;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;


public class MakeBouquet {

    private View view;
    private Scanner scanner;
    private Staff staff;
    private int number;
    private String input;
    private CheckStaff checkStaff;
    private int randomNumber;
    private ArrayList<Integer> hasAccessories = new ArrayList<>();



    private ArrayList<Flowers> flowersInBouquet = new ArrayList<>();
    private ArrayList<Accessories> accessoriesInBouquet = new ArrayList<>();


    /**
     * Constructor
     * @param scanner for user`s input
     * @param view from class View
     */
    MakeBouquet(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }


    /**
     * Method startProcess
     * Main method of class MakeBounder
     */
    void startProcess() {

        checkStaff = new CheckStaff(scanner,view);

        view.printBundle(View.INPUT_BOUQUET);
        view.printStaffFromStore(FlowerStore.class);

        addStaffToBouquet(0,View.INPUT_CHOICE_FLOWERS);

        view.printBundle(View.OUTPUT_VALUES);
        for (Staff fl:flowersInBouquet) {
            view.printMessage(fl.getName());
        }

        view.printBundle(View.INPUT_ACCESSORIES);
        view.printStaffFromStore(AccessoryStore.class);

        addStaffToBouquet(1,View.INPUT_CHOICE_ACCESSORIES);

        view.printBundle(View.OUTPUT_VALUES);
        for (Staff fl:accessoriesInBouquet) {
            view.printMessage(fl.getName());
        }

        MakeFunctions makeFunctions = new MakeFunctions(scanner,view,checkStaff,flowersInBouquet,accessoriesInBouquet);
        makeFunctions.functions();

    }

    /**
     * Adding staff to my bouquet
     * @param className
     * @param message
     */
    private void addStaffToBouquet(int className,String message){
        view.printBundle(message);
        switch (className){
            case 0:
                number = checkStaff.checkValueForStaff(scanner);
                getRandomFlowerValue(number);
                break;
            case 1:
                number = checkStaff.checkValueForStaff(scanner,AccessoryStore.values().length);
                getRandomAccessoriesValue(number);
                break;
        }
    }


    /**
     *  Creating new objects for Accessories
     * @param number for number of values
     */
    private void getRandomFlowerValue(int number){
        for (int i = 0; i < number; i++) {
            randomNumber = (int) (Math.random() * (FlowerStore.values().length));
            for (FlowerStore flowers: FlowerStore.values()) {
                if (randomNumber == flowers.ordinal()){
                    staff = new Flowers(flowers);
                    flowersInBouquet.add((Flowers) staff);
                    break;
                }
            }
        }
    }

    /**
     * Creating new objects for Accessories
     * @param number for number of values
     */
    private void getRandomAccessoriesValue(int number){
        for (int i = 0; i < number; i++) {
            randomNumber = (int) (Math.random() * (AccessoryStore.values().length));
            if (i != 0) {
                while (hasAccessories.contains(randomNumber)) {
                    randomNumber = (int) (Math.random() * (AccessoryStore.values().length));
                }
            }
            hasAccessories.add(randomNumber);
            for (AccessoryStore accessory: AccessoryStore.values()) {
                if (randomNumber == accessory.ordinal()){
                    staff = new Accessories(accessory);
                    accessoriesInBouquet.add((Accessories)staff);
                    break;
                }
            }
        }
    }
}