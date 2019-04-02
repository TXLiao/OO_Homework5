import com.oocourse.elevator1.PersonRequest;

public class Thread2 extends Thread {
    private final People temp;
    private static int stop = 1;

    public Thread2(People m) {
        this.temp = m;
    }

    public synchronized void run() {
        try {
            while (!temp.getInputState()) {
                Thread.sleep(1);
                while (!temp.isEmpty()) {
                    PersonRequest current = temp.getPerson();
                    ElevatorRun elevator = new ElevatorRun(current,stop);
                    elevator.loadPerson();
                    stop = elevator.getStop();
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
