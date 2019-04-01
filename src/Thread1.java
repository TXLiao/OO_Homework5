import com.oocourse.elevator1.ElevatorInput;
import com.oocourse.elevator1.PersonRequest;

public class Thread1 extends Thread {
    public final People m;

    public Thread1(People m) {
        this.m = m;
    }
    public synchronized void run() {
        try {
            //People m = new People();
            ElevatorInput elevatorInput = new ElevatorInput(System.in);
            while (true) {
                PersonRequest request = elevatorInput.nextPersonRequest();
                if (request == null) {
                    break;
                } else {
                    //System.out.println("sss");
                    m.setPerson(request);
                }
            }
            elevatorInput.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
