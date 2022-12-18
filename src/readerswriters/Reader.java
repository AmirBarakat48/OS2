
package readerswriters;

/**
 *
 * @author Amir Barakat
 */

class Reader implements Runnable {
    private final readerswriters.ReadWriteLock lock;

    public Reader(readerswriters.ReadWriteLock rw) 
    { lock = rw; }

    @Override
    public void run() {
        while (true) {
            try {
                              //System.out.println(Main.input1.getText());

                lock.readLock();
                System.out.println("Thread "+Thread.currentThread().getName() + " is READING");               //critical section
               Thread.sleep(2000);                                                                     //critical section
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");    //critical section
                lock.readUnLock();
                Thread.sleep(1000); //out of critical section
            } catch (InterruptedException e) {
            }
        }
    }
}