package view;

import controller.ThreadTriatlo;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		
		int armas = 5;
		int permissao = 1;
		Semaphore semaforo = new Semaphore(armas);
		Semaphore semaforo2 = new Semaphore(permissao);
		
		for(int idAtleta = 1 ; idAtleta <= 25 ; idAtleta ++) {
			Thread thread = new ThreadTriatlo(idAtleta, semaforo, semaforo2);
			thread.start();
		}
		
	}

}
