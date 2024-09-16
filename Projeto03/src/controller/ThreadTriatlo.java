package controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ThreadTriatlo extends Thread {

	private int idAtleta;
	private int distancia;
	private int velocidade;
	private int tempo;
	private int percorrido;
	private int pontosTiro;
	private int[] alvo = new int[3];
	private int soma;
	private static int pontos = 250;
	private int pontuacao;
	private static int[] rankingId = new int[25];
	private static int[] rankingPontuacao = new int[25];
	private static int aux;
	private Semaphore semaforo;
	private Semaphore semaforo2;

	public ThreadTriatlo(int idAtleta, Semaphore semaforo, Semaphore semaforo2) {
		this.idAtleta = idAtleta;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
	}

	@Override
	public void run() {
		Corrida();
		try {
			semaforo.acquire();
			TiroAoAlvo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		Ciclismo();
		try {
			semaforo2.acquire();
			Ranking();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo2.release();
		}
	}

	public void Corrida() {
		distancia = 300;
		tempo = 30;
		for (percorrido = 0; percorrido < distancia; percorrido = percorrido + velocidade) {
			velocidade = (int) ((Math.random() * 21) + 5);
			try {
				sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println("#" + idAtleta + " " + percorrido);
		}
	}

	public void TiroAoAlvo() {
		for (int i = 0; i < 3; i++) {
			tempo = (0 + (int) (Math.random() * ((3000 - 500) + 1)));
			try {
				sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			pontosTiro = (0 + (int) (Math.random() * ((10 - 0) + 1)));
			alvo[i] = pontosTiro;
			soma = soma + pontosTiro;
//			System.out.println("#" + idAtleta + " " + pontosTiro);
		}

	}

	public void Ciclismo() {
		distancia = 500;
		tempo = 40;
		for (percorrido = 0; percorrido < distancia; percorrido = percorrido + velocidade) {
			velocidade = (int) ((Math.random() * 21) + 5);
			try {
				sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println("#" + idAtleta + " " + percorrido);
		}
	}

	public void Ranking() {
		pontuacao = pontos + soma;
		rankingId[aux] = idAtleta;
		rankingPontuacao[aux] = pontuacao;
		pontos -= 10;
		aux += 1;

		if (aux == 25) {
			for (int i = 0; i < 24; i++) {
				for (int j = i + 1; j < 25; j++) {
					if (rankingPontuacao[i] < rankingPontuacao[j]) {
						int inter = rankingPontuacao[i];
						rankingPontuacao[i] = rankingPontuacao[j];
						rankingPontuacao[j] = inter;
						inter = rankingId[i];
						rankingId[i] = rankingId[j];
						rankingId[j] = inter;
					}
				}
			}
			for (int i = 0; i < 25; i++) {
				System.out.println("#" + rankingId[i] + " Atleta recebeu a pontuação final de: " + rankingPontuacao[i]);
			}
		}
	}

}