package controller;

import java.util.concurrent.Semaphore;

public class ThreadAvioes extends Thread {

	private String[] pistas = { "Norte", "Sul" };
	private int pista;
	private int duracao;
	private int idAviao;
	private Semaphore semaforo;
	private Semaphore semaforo2;

	public ThreadAvioes(int idAviao, Semaphore semaforo, Semaphore semaforo2) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;

	}

	@Override
	public void run() {
		Pista();
		if (pistas[pista] == "Norte") {
			try {
				semaforo.acquire();
				Manobra();
				Taxiar();
				Decolagem();
				Afastamento();
			} catch (Exception e) {

			} finally {
				semaforo.release();
			}
		}
		if (pistas[pista] == "Sul") {
			try {
				semaforo2.acquire();
				Manobra();
				Taxiar();
				Decolagem();
				Afastamento();
			} catch (Exception e) {

			} finally {
				semaforo2.release();
			}
		}

	}

	public void Pista() {
		pista = (0 + (int) (Math.random() * ((1 - 0) + 1)));
	}

	public void Manobra() {
		duracao = (int) ((Math.random() * 301) + 400);
		try {
			sleep(duracao);
		} catch (Exception e) {

		}
		System.out.println("#" + idAviao + " Avião manobrou em: " + duracao + "ms na pista " + pistas[pista]);
	}

	public void Taxiar() {
		duracao = (int) ((Math.random() * 501) + 500);
		try {
			sleep(duracao);
		} catch (Exception e) {

		}
		System.out.println("#" + idAviao + " Avião taxiou em: " + duracao + "ms na pista " + pistas[pista]);
	}

	public void Decolagem() {
		duracao = (int) ((Math.random() * 601) + 200);
		try {
			sleep(duracao);
		} catch (Exception e) {

		}
		System.out.println("#" + idAviao + " Avião decolou em: " + duracao + "ms na pista " + pistas[pista]);
	}

	public void Afastamento() {
		duracao = (int) ((Math.random() * 301) + 500);
		try {
			sleep(duracao);
		} catch (Exception e) {

		}
		System.out.println("#" + idAviao + " Avião se afastou em: " + duracao + "ms na pista " + pistas[pista]);
	}

}
