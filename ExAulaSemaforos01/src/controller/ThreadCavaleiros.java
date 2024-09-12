package controller;

import java.util.concurrent.Semaphore;

public class ThreadCavaleiros extends Thread {

	private Semaphore semaforo;
	private int idCavaleiros;
	private static int verificacao;
	private static int tocha = 1;
	private static int pedra = 1;

	public ThreadCavaleiros(int idCavaleiros, Semaphore semaforo) {
		this.idCavaleiros = idCavaleiros;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		Corredor();
		Portas();
	}

	private void Corredor() {
		int velocidade = (int) ((Math.random() * 3) + 2);
		int percurso = 0;

		while (percurso <= 200) {
			try {
				sleep(50);
			} catch (Exception e) {
			}
			percurso = percurso + velocidade;
//			System.out.println("#" + idCavaleiros + " percurso: " + percurso);
			if (percurso >= 50 && percurso < 56 && tocha == 1) {
				tocha--;
				try {
					semaforo.acquire();
					velocidade = Tocha(velocidade);
				} catch (Exception e) {
				} finally {
					semaforo.release();
				}
			}
			if (percurso >= 150 && percurso < 156 && pedra == 1 && velocidade == (int) ((Math.random() * 3) + 2)) {
				pedra--;
				try {
					semaforo.acquire();
					velocidade = Pedra(velocidade);
				} catch (Exception e) {
				} finally {
					semaforo.release();
				}
			}

		}

	}

	private int Tocha(int velocidade) {
		velocidade = (int) ((Math.random() * 3) + 4);
		System.out.println("#" + idCavaleiros + " Cavaleiro pegou a tocha!");
		return velocidade;
	}

	private int Pedra(int velocidade) {
		velocidade = (int) ((Math.random() * 3) + 4);
		System.out.println("#" + idCavaleiros + " Cavaleiro pegou a pedra!");
		return velocidade;
	}

	private void Portas() {
		System.out.println("#" + idCavaleiros + " Cavaleiro chegou a porta");
	}

}
