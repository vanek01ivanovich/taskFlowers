import controller.CheckStaff;
import controller.Controller;
import org.junit.BeforeClass;
import view.View;

import java.util.Scanner;

public class TestTask {
    private static Controller controller;
    private static CheckStaff checkStaff;
    private static View view;
    private static Scanner scanner;

    @BeforeClass
    public static void runInitialize(){
        view = new View();
        scanner = new Scanner(System.in);
        controller = new Controller(view);
        checkStaff = new CheckStaff(scanner,view);
    }

}
