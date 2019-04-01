import com.oocourse.elevator1.PersonRequest;

import java.util.LinkedList;
import java.util.Queue;

public class People {
    private static Queue<PersonRequest> person = new LinkedList<PersonRequest>();

    public synchronized PersonRequest getPerson() throws Exception {
        if (person.isEmpty()) {
            //System.out.println(person.isEmpty());
            wait();
           // System.out.println(person.isEmpty());
        }
        notifyAll();
        return person.poll();
    }

    public synchronized void setPerson(PersonRequest a) throws Exception {
        person.offer(a);
        //System.out.println(person.size());
        notifyAll();
        //System.out.println(person.size());
    }
}
