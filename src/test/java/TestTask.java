import controller.CheckStaff;
import controller.Controller;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import view.View;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    @Test
    public void testCheckIntValueForLanguage(){
        scanner = new Scanner("1");
        Assert.assertEquals("Input 1 from user",1,controller.checkIntValueForLanguage(scanner));
        scanner = new Scanner("0");
        Assert.assertEquals("Input 0 from user",0,controller.checkIntValueForLanguage(scanner));
    }

    @Test
    public void testCheckValueForStaff(){
        scanner = new Scanner("15");
        Assert.assertEquals(15,checkStaff.checkValueForStaff(scanner));
        scanner = new Scanner("2");
        Assert.assertEquals(2,checkStaff.checkValueForStaff(scanner));
    }
}
