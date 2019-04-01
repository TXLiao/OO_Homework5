import com.oocourse.TimableOutput;
import com.oocourse.elevator1.PersonRequest;

public class ElevatorRun {
    private int id;
    private int from;
    private int to;
    private int stop = 1;

    static final long OPEN = 250;
    static final long CLOSE = 250;
    static final long PERFLOOR = 500;

    public ElevatorRun(PersonRequest a) {
        this.id = a.getPersonId();
        this.from = a.getFromFloor();
        this.to = a.getToFloor();
    }

    public void loadPerson() throws Exception {
        moveTime(stop,from);
        doorOpen(from);
        moveIn(from);
        doorClose(from);
        stop = from;
        moveTime(stop,to);
        doorOpen(to);
        moveOut(to);
        doorClose(to);
        stop = to;
    }

    void moveTime(int a,int b) {
        int gap = Math.abs(a - b);
        try {
            Thread.sleep(gap * PERFLOOR);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void doorOpen(int stop) {
        TimableOutput.println("OPEN-" + stop);
        try {
            Thread.sleep(OPEN);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void doorClose(int stop) {
        try {
            Thread.sleep(CLOSE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        TimableOutput.println("CLOSE-" + stop);
    }

    void moveIn(int stop) {
        TimableOutput.println(String.format("IN-%d-%d", id, stop));
    }

    void moveOut(int stop) {
        TimableOutput.println(String.format("OUT-%d-%d", id, stop));
    }
}