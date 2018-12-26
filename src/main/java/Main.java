import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        NextBusManager manager = NextBusManager.getInstance();
        manager.getLineEta(1, 1234 , "11A");
        manager.getLineEta(2, 5678 , "12A");

    }
}
