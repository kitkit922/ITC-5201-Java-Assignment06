package Q2;

public class ThreadSyncQ2 extends Thread {

    static int sum = 0;
    static Integer obj = Integer.valueOf(sum);

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

    public static synchronized void Add() {

        sum = obj.intValue();
        obj = Integer.valueOf(++sum);
        // System.out.println("Obj\t" + obj);
    }

}
