package controller;

import view.View;

import java.util.Scanner;

public class Controller {

    private View view;

    /**
     * Constructors
     * @param view Object of Class View
     */
    public Controller(View view) {
        this.view = view;
    }


    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        view.printMessage(View.urkEngInput);

        view.languageChoice(checkIntValueForLanguage(scanner));

        MakeBouquet makeBouquet = new MakeBouquet(scanner,view);
        makeBouquet.startProcess();


    }

    /**
     * @param scanner Object for user`s input
     * @return Integer of input from user
     */
    public int checkIntValueForLanguage(Scanner scanner){
        String input = scanner.nextLine();
        while (!(input.equals("1") || input.equals("0"))){
            view.printMessage(View.wrongEngUkrInput);
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

}
