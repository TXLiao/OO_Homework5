import com.oocourse.elevator1.PersonRequest;

import java.util.LinkedList;
import java.util.Queue;

public class People {
    private static boolean inputState = false;
    private static Queue<PersonRequest> person =
            new LinkedList<PersonRequest>();

    public synchronized PersonRequest getPerson() throws Exception {
        if (person.isEmpty()) {
            return null;
        }
        notifyAll();
        return person.poll();
    }

    public synchronized void setPerson(PersonRequest a) throws Exception {
        person.offer(a);
        notifyAll();
    }

    public boolean isEmpty() {
        return person.isEmpty();
    }

    public boolean getInput() {
        return inputState;
    }

    public void setInput(Boolean a) {
        inputState = a;
    }
}
