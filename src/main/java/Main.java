import controller.Controller;
import controller.MakeBouquet;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        controller.processUser();

    }
}
