import controller.Controller;
import controller.MakeBouquet;
import view.View;

/**
 * Main Class,the start of my program
 * @author Ivan
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        controller.processUser();

    }
}
