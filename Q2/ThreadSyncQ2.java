package Q2;

/**
 * This is a class for question02 without Sync
 * 
 * @author Wenhao
 * @id n01555914
 */
public class ThreadSyncQ2 extends Thread {

    static int sum = 0;
    static Integer obj = Integer.valueOf(sum);// Define an Integer wrapper object to hold sum

    public static void main(String[] args) {
        System.out.println("\n--------Demo of Q2 with Sync--------\n");

        System.out.println("Sum Initial Value:\t" + sum);

        for (int i = 0; i < 1000; i++) {
            ThreadSyncQ2 t = new ThreadSyncQ2();
            t.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Sum Final Value:\t" + sum);
    }

    @Override
    public void run() {
        Add();
    }

    public static synchronized void Add() {// lock Integer obj using synchronization block, preventing concurrence

        sum = obj.intValue();
        obj = Integer.valueOf(++sum);// adds 1 to a variable sum; increment first then use the value
        // System.out.println("Obj\t" + obj);
    }

}
