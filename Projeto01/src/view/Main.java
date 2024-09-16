package view;

import controller.ThreadCavaleiros;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		Semaphore semaforo2 = new Semaphore(permissoes);
		Semaphore semaforo3 = new Semaphore(permissoes);

		for (int idCavaleiros = 1; idCavaleiros <= 4; idCavaleiros++) {
			Thread thread = new ThreadCavaleiros(idCavaleiros, semaforo, semaforo2, semaforo3);
			thread.start();
		}

	}

}
