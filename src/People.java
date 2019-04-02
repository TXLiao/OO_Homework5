import com.oocourse.elevator1.PersonRequest;

import java.util.LinkedList;
import java.util.Queue;

public class People {
    private static boolean inputState = false;
    private static Queue<PersonRequest> person =
            new LinkedList<PersonRequest>();

    public synchronized PersonRequest getPerson() throws Exception {
        notifyAll();
        return person.poll();
    }

    public synchronized void setPerson(PersonRequest a) throws Exception {
        notifyAll();
        person.offer(a);

    }

    public boolean isEmpty() {
        return person.isEmpty();
    }

    public boolean getInputState() {
        return inputState;
    }

    public void setInputState(Boolean a) {
        inputState = a;
    }
}
