package view;

import controller.ThreadCavaleiros;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCavaleiros = 1 ; idCavaleiros <= 4 ; idCavaleiros ++) {
			Thread thread = new ThreadCavaleiros(idCavaleiros, semaforo);
			thread.start();
		}

	}

}
