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

public class cinema {

	private static final int TOTALSEATS = 10;
	private int remainingSeats;
	public cinema(int numOfSeats) {
		this.remainingSeats = numOfSeats;
        }
        public cinema() {
		this.remainingSeats = TOTALSEATS;
        }


	public int getRemainingSeats() throws InterruptedException {
            try {
                ReadWriteLock.readLock();
            } catch (InterruptedException ex) {
                Logger.getLogger(cinema.class.getName()).log(Level.SEVERE, null, ex);
            }
		try {
			return remainingSeats;
		} finally {
                ReadWriteLock.readUnLock();
		}
	}

	public boolean bookTickets(int numOfSeatsToBook) {
            try {
                ReadWriteLock.writeLock();
            } catch (InterruptedException ex) {
                Logger.getLogger(cinema.class.getName()).log(Level.SEVERE, null, ex);
            }

		try {
			if (remainingSeats >= numOfSeatsToBook) {
				this.remainingSeats = remainingSeats - numOfSeatsToBook;
				return true;
			} else
				return false;
		} finally {
                try {
                    ReadWriteLock.writeUnLock();
                } catch (InterruptedException ex) {
                    Logger.getLogger(cinema.class.getName()).log(Level.SEVERE, null, ex);
                }

		}
	}

	public void cancelTickets(int numSeatsToCancel) {
            try {
                ReadWriteLock.writeLock();
            } catch (InterruptedException ex) {
                Logger.getLogger(cinema.class.getName()).log(Level.SEVERE, null, ex);
            }

		this.remainingSeats = remainingSeats + numSeatsToCancel;
            try {
                ReadWriteLock.writeUnLock();
            } catch (InterruptedException ex) {
                Logger.getLogger(cinema.class.getName()).log(Level.SEVERE, null, ex);
            }


	}

}
