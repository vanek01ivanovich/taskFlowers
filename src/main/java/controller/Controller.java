package controller;

import view.View;

import java.util.Scanner;

public class Controller {

    private View view;
    private String input;

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

    private int checkIntValueForLanguage(Scanner scanner){
        this.input = scanner.nextLine();

        while (!(input.equals("1") || input.equals("0"))){
            view.printMessage(View.wrongEngUkrInput);
            this.input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

}
