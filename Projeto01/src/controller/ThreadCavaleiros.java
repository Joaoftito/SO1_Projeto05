package controller;

import java.util.concurrent.Semaphore;

public class ThreadCavaleiros extends Thread {

	private Semaphore semaforo;
	private Semaphore semaforo2;
	private Semaphore semaforo3;
	private int idCavaleiros;
	private int i;
	private int velocidade;
	private static int tocha = 1;
	private static int pedra = 1;
	private static int[] portas = { 0, 0, 1, 0 };
	private int posicao;

	public ThreadCavaleiros(int idCavaleiros, Semaphore semaforo, Semaphore semaforo2, Semaphore semaforo3) {
		this.idCavaleiros = idCavaleiros;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
		this.semaforo3 = semaforo3;

	}

	@Override
	public void run() {
		Corredor();
		try {
			semaforo.acquire();
			Portas();
		} catch (Exception e) {

		} finally {
			semaforo.release();
		}
	}

	private void Corredor() {

		int percurso = 2000;
		velocidade = (int) ((Math.random() * 3) + 2);
		for (i = 0; i < percurso; i = i + velocidade) {
			try {
				sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCavaleiros + " Cavaleiro caminhou: " + i + "m");
			try {
				semaforo2.acquire();
				Tocha();
			} catch (Exception e) {

			} finally {
				semaforo2.release();
			}
			try {
				semaforo3.acquire();
				Pedra();
			} catch (Exception e) {

			} finally {
				semaforo3.release();
			}
		}

	}

	private void Portas() {

		System.out.println("#" + idCavaleiros + " Cavaleiro chegou nas portas!");
		int verificacao = 0;
		posicao = (0 + (int) (Math.random() * ((3 - 0) + 1)));
		while (verificacao == 0) {
			if (portas[posicao] == 1) {
				System.out.println("#" + idCavaleiros + " Cavaleiro encontrou a saída!");
				portas[posicao] = -1;
				verificacao++;
			} else {
				if (portas[posicao] == 0) {
					System.out.println("#" + idCavaleiros + " Cavaleiro foi devorado pelo monstro!");
					portas[posicao] = -1;
					verificacao++;
				} else {
					if (portas[posicao] == -1) {
//						System.err.println("#" + idCavaleiros + " Cavaleiro não pode entrar nessa porta pois já foi utilizada!");
						posicao = (0 + (int) (Math.random() * ((3 - 0) + 1)));
					}
				}

			}

		}
	}

	private void Tocha() {
		if (i >= 500 && i <= 508 && tocha == 1) {
			tocha--;
			velocidade = (int) ((Math.random() * 3) + 4);
			System.out.println("#" + idCavaleiros + " Cavaleiro pegou a tocha e teve sua velocidade aumentada!");
		}
	}

	private void Pedra() {
		if (i >= 1500 && i <= 1508 && pedra == 1 && velocidade == (int) ((Math.random() * 3) + 2)) {
			pedra--;
			velocidade = (int) ((Math.random() * 3) + 4);
			System.out.println("#" + idCavaleiros + " Cavaleiro pegou a pedra brilhosa e teve sua velocidade aumentada!");
		}
	}
}