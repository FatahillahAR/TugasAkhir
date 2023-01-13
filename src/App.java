import model.Hotel;
import view.LoginPage;

public class App {
    public static void main(String[] args) {
        Hotel.initialData();

        new HomePageFrame();

    }
}
