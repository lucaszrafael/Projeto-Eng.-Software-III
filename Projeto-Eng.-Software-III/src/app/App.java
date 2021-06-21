package app;

import java.io.IOException;
import controllers.*;

public class App {
    public static void main(String[] args) throws IOException {
        Controller main = new Controller();
        main.start();
    }
}

