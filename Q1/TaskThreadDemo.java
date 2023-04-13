package Q1;

import java.awt.*;

import javax.swing.*;

public class TaskThreadDemo extends JFrame {

  static JTextArea textArea;

  TaskThreadDemo() {
    textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    JScrollPane panel = new JScrollPane(textArea);
    panel.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    add(panel, BorderLayout.CENTER);
    pack();

    setDefaultCloseOperation(3);
    setSize(500, 250);
    setTitle("Concurrent Output");
    setVisible(true);

  }

  public static void main(String[] args) {

    TaskThreadDemo demo = new TaskThreadDemo();

    // // Create tasks
    Runnable printA = new PrintChar('a', 3000, textArea);
    Runnable printB = new PrintChar('b', 3000, textArea);
    Runnable print100 = new PrintNum(2000, textArea);

    // // Create threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);

    thread1.setPriority(Thread.MAX_PRIORITY);

    // // Start threads
    thread1.start();
    thread2.start();
    thread3.start();
  }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {
  private char charToPrint; // The character to print
  private int times; // The times to repeat
  JTextArea textArea;

  /**
   * Construct a task with specified character and number of
   * times to print the character
   */
  public PrintChar(char c, int t, JTextArea tA) {
    charToPrint = c;
    times = t;
    textArea = tA;
  }

  @Override /**
             * Override the run() method to tell the system
             * what the task to perform
             */
  public void run() {
    for (int i = 0; i < times; i++) {
      String value = " " + String.valueOf(charToPrint);
      textArea.append(value);
    }
  }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
  private int lastNum;
  JTextArea textArea;

  /** Construct a task for printing 1, 2, ... i */
  public PrintNum(int n, JTextArea ta) {
    lastNum = n;
    textArea = ta;
  }

  @Override /** Tell the thread how to run */
  public void run() {
    for (int i = 1; i <= lastNum; i++) {
      String value = " " + Integer.toString(i);
      textArea.append(value);
      Thread.yield();
    }
  }
}
