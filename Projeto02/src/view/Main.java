package view;

import controller.ThreadAvioes;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

		int norte = 1;
		int sul = 1;
		Semaphore semaforo = new Semaphore(norte);
		Semaphore semaforo2 = new Semaphore(sul);

		for (int idAviao = 1; idAviao <= 12; idAviao++) {
			Thread thread = new ThreadAvioes(idAviao, semaforo, semaforo2);
			thread.start();
		}
	}

}
