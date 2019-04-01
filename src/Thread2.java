import com.oocourse.elevator1.PersonRequest;

public class Thread2 extends Thread {
    public final People m;

    public Thread2(People m) {
        this.m = m;
    }
    public synchronized void run() {
        //1-FROM-1-TO-2People m = new People();
        try {
            //System.out.println("into");
            PersonRequest current = m.getPerson();
            while (current != null) {
                ElevatorRun elevstor = new ElevatorRun(current);
                elevstor.loadPerson();
                current = m.getPerson();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
