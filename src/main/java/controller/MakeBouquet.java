package controller;

import model.entity.*;
import model.entity.enumValues.AccessoryStore;
import model.entity.enumValues.FlowerStore;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class MakeBouquet {

    private View view;
    private Scanner scanner;
    private Staff staff;
    private int number;
    private String input;
    private CheckStaff checkStaff;
    private int randomNumber;



    private ArrayList<Flowers> flowersInBouquet = new ArrayList<>();
    private ArrayList<Accessories> accessoriesInBouquet = new ArrayList<>();


    MakeBouquet(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    void startProcess() {

        checkStaff = new CheckStaff(scanner,view);

        view.printBundle(View.INPUT_BOUQUET);
        view.printFlowersFromStore();

        addStaffToBouquet(0,View.INPUT_CHOICE_FLOWERS);

        for (Staff fl:flowersInBouquet) {
            System.out.println(fl.getName());
        }

        view.printBundle(View.INPUT_ACCESSORIES);
        view.printAccessoriesFromStore();

        addStaffToBouquet(1,View.INPUT_CHOICE_ACCESSORIES);

        for (Staff fl:accessoriesInBouquet) {
            System.out.println(fl.getName() + " - " + fl.getPrice());
        }

        MakeFunctions makeFunctions = new MakeFunctions(scanner,view,checkStaff,flowersInBouquet,accessoriesInBouquet);
        makeFunctions.functions();

    }

    private void addStaffToBouquet(int className,String message){
        view.printBundle(message);
        staff = null;
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

    private void getRandomAccessoriesValue(int number){
        for (int i = 0; i < number; i++) {
            randomNumber = (int) (Math.random() * (AccessoryStore.values().length));
            for (AccessoryStore accessory: AccessoryStore.values()) {
                if (randomNumber == accessory.ordinal()){
                    //if (!accessoriesInBouquet.isEmpty() && !accessoriesInBouquet.contains(accessory)){
                    staff = new Accessories(accessory);
                    accessoriesInBouquet.add((Accessories)staff);
                    break;
                   // }

                }
            }
        }
    }






}
