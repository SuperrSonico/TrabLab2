package br.unisinos;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jogo {

	private Jogador player;
	private Jogador cpu;
	private Tabuleiro tCpu;
	private Tabuleiro tPlayer;

	public Jogo(String nome) {
		player = new Jogador(nome);
		cpu = new Jogador();
		tCpu = new Tabuleiro();
		tPlayer = new Tabuleiro();
	}

	public void iniciaJogo() {
		System.out.println("Bem Vindo!");
		System.out.println("");
		System.out.println(
				"Vence o primeiro a acertar todas as pecas do inimigo.");
		System.out.println("");
		System.out.println("Tenha um Bom jogo!");
		System.out.println("");

		// faz jogada
		tPlayer.showMap(player);

	}

	private int[] realizaJogada() {
		Scanner s = new Scanner(System.in);
		int tiro[] = new int[2];
		int linha = -1;
		int coluna = -1;

		System.out.println("Linha:");
		do {
			try {
				linha = s.nextInt();
			} catch (Exception e) {
				System.out.println("Invalido! Linha:");
				s.nextInt();

			}
			if (linha < 1 || linha > 10) {
				System.out.println("Invalido! Linha:");
			}
		} while (linha < 1 || linha > 10);
		tiro[0] = linha;
		tiro[0]--;
		System.out.println("Coluna:");
		do {
			coluna = s.nextInt();
			if (coluna < 1 || coluna > 10) {
				System.out.println("Invalido! Coluna:");
			}
		} while (coluna < 1 || coluna > 15);
		tiro[1] = coluna;
		tiro[1]--;
		return tiro;

		// int vR[] = new int[2];
		// if (cord.length() != 3 || cord.length() != 5) {
		// System.out.println("Invalid Input");
		// }
		//
		// if (Character.isDigit(cord.charAt(0))) {
		// System.out.println("its a number");
		// if(Character.isDigit(cord.charAt())){
		//
		// }
		// System.out.println(cord.charAt(0));
		// vR[0] = (int) (cord.charAt(0));
		// System.out.println(cord.charAt(2));
		// vR[1] = (int) (cord.charAt(2));
		// } else if (cord.charAt(0) == '[') {
		// System.out.println("e um colchetes");
		// System.out.println(cord.charAt(1));
		// vR[0] = (int) (cord.charAt(1));
		// System.out.println(cord.charAt(3));
		// vR[1] = (int) (cord.charAt(3));
		// } else {
		// System.out.println("Nothing");
		// vR[0] = -1;
		// vR[1] = -1;
		// }
	}

	// DOCUMENTADO
	/*
	 * private int realizaJogada(int jogador, int linha, int coluna) { //
	 * RETORNOS // -2 ERRO ja lançou um tiro no mesmo local // -1 acertou a agua
	 * // 1 acertou um PrA // 2 acertou CRU // 3 acertou SUB if (jogador == 1) {
	 * // CPU if (tabuleiro[linha][coluna] == -1) { // Alvo ja atingido, retorna
	 * um erro return -2; } else if (tabuleiro[linha][coluna] == 1) {
	 * 
	 * } else if (tabuleiro[linha][coluna] == 2) {
	 * 
	 * } else if (tabuleiro[linha][coluna] == 3) {
	 * 
	 * } return -1; } // JOGADOR return -1;
	 * 
	 * }
	 */

}
