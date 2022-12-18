
package readerswriters;

/**
 *
 * @author Amir Barakat
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class ReadersWriters {

    
 public static void main(String [] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReadWriteLock RW = new ReadWriteLock();
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        
        executorService.execute(new Reader(RW));
        executorService.execute(new Reader(RW));
        executorService.execute(new Reader(RW));
        executorService.execute(new Reader(RW));
        executorService.execute(new Reader(RW));
        executorService.execute(new Reader(RW));
        
        
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
        executorService.execute(new Writer(RW));
       
        executorService.shutdown();
    }
}
