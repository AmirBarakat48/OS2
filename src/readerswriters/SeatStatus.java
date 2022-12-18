package readerswriters;


/**
 *
 * @author Amir Barakat
 */

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class SeatStatus implements Runnable {
	private cinema film = new cinema();

	public SeatStatus(cinema fl) {
		this.film = fl;
	}

        @Override
	public void run() {
//		System.out.println("Started Reader Thread : "
//				+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		Date date = new Date();
                
            try {
                System.out.println("Thread " + Thread.currentThread().getName()
                        + ": Remaining Seats at " + date.toString() + " Is :"
                        + film.getRemainingSeats()+" seats");
            } catch (InterruptedException ex) {
                Logger.getLogger(SeatStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}

