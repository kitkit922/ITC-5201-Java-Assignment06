package Q4;

import java.util.*;

/**
 * This is a class to demostrate output.
 */
public class Q4Demo {

    public static void main(String[] args) {
        System.out.println("\n--------Demo of Q3 with Exception--------\n");

        Thread01 t1 = new Thread01();
        Thread02 t2 = new Thread02();

        t1.start();
        t2.start();
    }
}

/**
 * This is the class represents the first thread.
 */
class Thread01 extends Thread {
    static HashSet<Integer> set;

    Thread01() {
        set = new HashSet<Integer>();// first thread creates a hash set
        set.add(-1);// filled with numbers
        set.add(0);// filled with numbers
    }

    private void AddValue() {
        synchronized (Thread01.set) {// lock hash set using synchronization block, preventing concurrence
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
                set.add(i);// adds a new number to the set every second.
                System.out.println("Add value:\t" + set);
            }
        }
    }

    @Override
    public void run() {
        AddValue();
    }
}

/**
 * This is the class represents the second thread.
 */
class Thread02 extends Thread {

    private void ListValue() {
        synchronized (Thread01.set) {// lock hash set using synchronization block, preventing concurrence
            Iterator<Integer> it = Thread01.set.iterator();// obtains an iterator for the set
            while (it.hasNext()) {
                try {
                    sleep(1000);

                    Integer value = it.next();// traverses the set back and forth through the iterator every second.
                    System.out.println("List Value:\t" + value);
                } catch (InterruptedException ex) {
                    System.out.println("InterruptedException:\t" + ex.getMessage());
                } catch (ConcurrentModificationException ex) {
                    System.out.println("Error: \tConcurrentModificationException");// display
                                                                                   // tConcurrentModificationException
                    break;// teminates the while loop;
                }
            }
        }
    }

    @Override
    public void run() {
        ListValue();
    }
}