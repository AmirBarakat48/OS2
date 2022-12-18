/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerswriters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amir Barakat
 */

class SeatCancel implements Runnable {
	
	private cinema film = new cinema();
	private final int numOfSeatsToCancel;

	public SeatCancel(cinema film, int numOfSeatsToCancel) {
		this.film = film;
		this.numOfSeatsToCancel = numOfSeatsToCancel;
	}

	public void run() {
//		System.out.println("Started Writer-Cancel Thread : "
//				+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		film.cancelTickets(numOfSeatsToCancel);

            try {
                System.out.println("Thread :" + Thread.currentThread().getName()
                        + " Cancelled "+this.numOfSeatsToCancel+" Ticket. Remaining Seats: "
                        + film.getRemainingSeats());
            } catch (InterruptedException ex) {
                Logger.getLogger(SeatCancel.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}

