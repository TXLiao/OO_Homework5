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

    private static boolean outputState = false;

    public ElevatorRun(PersonRequest a,int stop) {
        this.id = a.getPersonId();
        this.from = a.getFromFloor();
        this.to = a.getToFloor();
        this.stop = stop;
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
        setOutput(true);
    }

    void moveTime(int a,int b) {
        int gap = Math.abs(a - b);
        try {
            Thread.sleep(gap * PERFLOOR + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void doorOpen(int stop) {
        TimableOutput.println("OPEN-" + stop);
        try {
            Thread.sleep(OPEN + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void doorClose(int stop) {
        try {
            Thread.sleep(CLOSE + 1);
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

    public void setOutput(Boolean a) {
        outputState = a;
    }

    public boolean getOutput() {
        return outputState;
    }

    public int getStop() {
        return stop;
    }
}
