import com.oocourse.elevator1.PersonRequest;

public class Thread2 extends Thread {
    private final People temp;

    public Thread2(People m) {
        this.temp = m;
    }

    public synchronized void run() {
        try {
            PersonRequest current = temp.getPerson();
            while (current != null) {
                ElevatorRun elevstor = new ElevatorRun(current);
                elevstor.loadPerson();
                current = temp.getPerson();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
