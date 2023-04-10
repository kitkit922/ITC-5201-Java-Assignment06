package assessment.assignment06.Q3;

import java.util.HashSet;
import java.util.Iterator;

public class Q3 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        Thread1 t1 = new Thread1(set);
        Thread2 t2 = new Thread2(set);

        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread {
    private HashSet<Integer> set;

    Thread1(HashSet<Integer> set) {
        this.set = set;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            int value = 1 * 10;
            set.add(value);
            System.out.println("Add value:\t" + value);
        }
    }
}

class Thread2 extends Thread {
    private HashSet<Integer> set;

    Thread2(HashSet<Integer> set) {
        this.set = set;
    }

    @Override
    public void run() {
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            Integer value = it.next();
            System.out.println("List Value:\t" + value);
        }
    }
}