import com.Greeting;
import com.engine.Engine;

public class Main {

    public static void main(String[] args) throws Exception {
        Greeting.displayGreeting();

        Engine engine = new Engine();
        engine.start();
    }
}
