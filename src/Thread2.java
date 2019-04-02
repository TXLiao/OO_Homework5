import com.oocourse.elevator1.PersonRequest;

public class Thread2 extends Thread {
    private final People temp;

    public Thread2(People m) {
        this.temp = m;
    }

    public synchronized void run() {
        try {

            while (!temp.getInput()) {
                while (!temp.isEmpty()) {
                    PersonRequest current = temp.getPerson();
                    ElevatorRun elevstor = new ElevatorRun(current);
                    elevstor.loadPerson();
                }
                Thread.sleep(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
