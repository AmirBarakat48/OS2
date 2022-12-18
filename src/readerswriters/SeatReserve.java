
package readerswriters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amir Barakat
 */

class SeatReserve implements Runnable {
	private cinema film = new cinema();
	private int numOfSeatsToBook;

	public SeatReserve(cinema fl, int numOfSeatsToBook) {
		this.film = fl;
		this.numOfSeatsToBook = numOfSeatsToBook;
	}

	public void run() {

//		System.out.println("Started Writer-Reserve Thread : "
//				+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		if (film.bookTickets(numOfSeatsToBook)) {
                    try {
                        System.out.println("Thread " + Thread.currentThread().getName()
                                + ": Booked " + numOfSeatsToBook
                                + " seat.......Remaining Seats: " + film.getRemainingSeats());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SeatReserve.class.getName()).log(Level.SEVERE, null, ex);
                    }
		} else {
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " No Seats Available to Book..");
		}
	}
}
