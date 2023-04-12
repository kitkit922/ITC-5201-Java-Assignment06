package Q2;

public class ThreadNoSyncQ2 extends Thread {
    static int sum = 0;
    static Integer obj = Integer.valueOf(sum);

    public static void main(String[] args) {
        System.out.println("\n--------Demo of Q2 with Non-Sync--------\n");

        System.out.println("Sum Initial Value:\t" + sum);

        for (int i = 0; i < 1000; i++) {
            ThreadNoSyncQ2 t = new ThreadNoSyncQ2();
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

    public void Add() {

        sum = obj.intValue();
        obj = Integer.valueOf(++sum);
        // System.out.println("Obj\t" + obj);
    }

}
