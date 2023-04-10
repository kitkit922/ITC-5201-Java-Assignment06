package assessment.assignment06.Q2;

public class Q2 extends Thread {
    static int sum = 0;
    static Integer obj = Integer.valueOf(sum);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Q2 t = new Q2();
            t.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Sum:\t" + sum);
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
