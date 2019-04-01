import com.oocourse.TimableOutput;
import com.oocourse.elevator1.PersonRequest;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TimableOutput.initStartTimestamp();
        People person = new People();
        Thread1 input = new Thread1(person);
        Thread2 output = new Thread2(person);
        input.start();
        //System.out.println("Thread2");
        output.start();
    }
}

//    public synchronized PersonRequest getPerson() throws Exception {
//        System.out.println("wait1");
//        System.out.println(person.size());
//        if (person.isEmpty()) {
//            wait();
//        }
//        System.out.println("wait");
//        notifyAll();
//        System.out.println("get");
//        return person.poll();
//    }
//
//    public synchronized void setPerson(PersonRequest a) throws Exception {
//        person.offer(a);
//        System.out.println("set" + person.isEmpty());
//        notifyAll();
//        System.out.println(person.isEmpty());
//    }
//}
