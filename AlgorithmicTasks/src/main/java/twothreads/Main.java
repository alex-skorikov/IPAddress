package twothreads;

/**
 * Start application.
 */
public class Main {
    /**
     * Main method.
     * @param args string[] arguments.
     */
    public static void main(String[] args) {
        Start start = new Start(20);
        try {
            start.startApplication();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
