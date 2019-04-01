import com.oocourse.TimableOutput;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        TimableOutput.initStartTimestamp();
        People person = new People();
        Thread1 input = new Thread1(person);
        Thread2 output = new Thread2(person);
        input.start();
        output.start();
        if (!input.isAlive() && person.isEmpty() && !output.isAlive()) {
            exit(0);
        }
    }
}
