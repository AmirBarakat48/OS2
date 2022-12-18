/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerswriters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Amir Barakat
 */

public class CinemaTicketingSystem {


	
public static void main(String [] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        	cinema c1 = new cinema();

		Thread[] users = new Thread[9];

		users[0] = new Thread(new SeatReserve(c1, 2));
		users[1] = new Thread(new SeatReserve(c1, 3));
                users[2] = new Thread(new SeatReserve(c1, 2));
                users[3] = new Thread(new SeatReserve(c1, 2));
                users[4] = new Thread(new SeatReserve(c1, 2));

		users[6] = new Thread(new SeatStatus(c1));
		users[7] = new Thread(new SeatCancel(c1, 3));
                users[5] = new Thread(new SeatStatus(c1));

                users[8] = new Thread(new SeatReserve(c1, 2));


		for (int i = 0; i < 9; i++) {
			users[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
				
		}
		for (int i = 0; i < 9; i++) {
			try {
				users[i].join();
			} catch (InterruptedException e) {

			}
    	}
	}
}
