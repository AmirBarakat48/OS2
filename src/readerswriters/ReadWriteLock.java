
package readerswriters;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Amir Barakat
 */
class ReadWriteLock{
    static Semaphore enter = new Semaphore(1);
    static Semaphore enter2 = new Semaphore(1);
    static Semaphore writer = new Semaphore(0);
   static int s_reader = 0;
   static int c_reader = 0;
   static boolean w_writer = false;
   
    ReadWriteLock( ) {     }
    
    static void readLock() throws InterruptedException {
        enter.acquire();
        s_reader++;
        enter.release();
    }
    
    static void readUnLock() throws InterruptedException {
        enter2.acquire();
        c_reader++;
        if(w_writer && s_reader == c_reader) {
            writer.release();
        }
        enter2.release();
    }
    
    static public void writeLock() throws InterruptedException {
        enter.acquire();
        enter2.acquire();
        if(s_reader == c_reader){
            enter2.release();
        }else{
            w_writer = true;
            enter2.release();
            writer.acquire();
            w_writer = false;
        }
    }
    
    static public void writeUnLock() throws InterruptedException {
        enter.release();
    }
    
};
