import com.oocourse.elevator1.ElevatorInput;
import com.oocourse.elevator1.PersonRequest;

public class Thread1 extends Thread {
    private final People temp;

    public Thread1(People m) {
        this.temp = m;
    }

    public synchronized void run() {
        try {
            ElevatorInput elevatorInput = new ElevatorInput(System.in);
            while (true) {
                PersonRequest request = elevatorInput.nextPersonRequest();
                if (request == null) {
                    break;
                } else {
                    temp.setPerson(request);
                }
            }
            elevatorInput.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
