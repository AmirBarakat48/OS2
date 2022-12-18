
package readerswriters;

/**
 *
 * @author Amir Barakat
 */

class Writer implements Runnable {
    private final ReadWriteLock lock;

    public Writer(ReadWriteLock rw) {
        lock = rw;
    }

    @Override
    public void run() {
        while (true){
            try {
                lock.writeLock();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");               //critical section
                Thread.sleep(2000);                                                                     //critical section
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");    //critical section
                lock.writeUnLock();
                Thread.sleep(1000); //out of critical section
            } catch (InterruptedException e) {
            }
        }
    }
}