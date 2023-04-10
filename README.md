# ITC-5201-Java-Assignment06

- Semester: #02
- Course: ITC-5201-Java
- Assignment: #05- Threading
- Group: #03
- Member:
  - Ansh Bhardwaj
  - Tsz Kit Cheung(Kevin)
  - Wenhao Fang(Simon)

---

## Use Case

- 1. Rewrite TaskThreadDemo.java to display the output in a GUI, as shown below.
- 2. Write a program that launches 1,000 threads. Each thread adds 1 to a variable sum that initially is 0. Define an Integer wrapper object to hold sum. Run the program with and without synchronization to see its effect.
- 3. The iterator is fail -fast.
  - Write a program to demonstrate it by creating two threads that concurrently access and modify a set.
  - The first thread creates a hash set filled with numbers and adds a new number to the set every second.
  - The second thread obtains an iterator for the set and traverses the set back and forth through the iterator every second.
  - You will receive a ConcurrentModificationException because the underlying set is being modified in the first thread while the set in the second thread is being traversed.
- 4. Using synchronization, correct the problem in the preceding exercise so that the second thread does not throw a ConcurrentModificationException
