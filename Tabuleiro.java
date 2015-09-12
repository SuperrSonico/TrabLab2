package br.unisinos;

public class Tabuleiro {
	private int[][] tabuleiro;

	// 0=AGUA
	// 1=PORTA AVIOES
	// 2=CRUZADOR
	// 3=SUBMARINOI
	// -1=TIRO

	public Tabuleiro() {
		tabuleiro = new int[10][15];
		geraTabuleiro();

	}

	// DONE
	private void geraTabuleiro() {
		setPortaAviao();
		setCruzador();
		setSubmarino();
	}

	// DONE
	private void setPortaAviao() {
		for (int i = 0; i < 3; i++) {
			if ((int) (Math.random() * 3) < 2) {
				// horizontal
				int linha = (int) (Math.random() * 10);
				int coluna = (int) (Math.random() * 11);
				// muda o tabuleiro
				boolean doesntFits;
				do {
					doesntFits = false;
					for (int j = coluna; j < coluna + 5; j++) {
						if (tabuleiro[linha][j] == 1) {
							doesntFits = true;
						}
					}
					if (doesntFits == true) {
						linha = (int) (Math.random() * 10);
						coluna = (int) (Math.random() * 11);
					}
				} while (doesntFits == true);
				for (int j = coluna; j < coluna + 5; j++) {
					tabuleiro[linha][j] = 1;
				}
			} else {
				// vertical
				int linha = (int) (Math.random() * 6);
				int coluna = (int) (Math.random() * 15);
				// muda o tabuleiro
				// testa se sobrepoe
				boolean doesntFits;
				do {
					doesntFits = false;
					for (int j = linha; j < linha + 5; j++) {
						if (tabuleiro[j][coluna] == 1)
							doesntFits = true;
					}
					if (doesntFits == true) {
						linha = (int) (Math.random() * 6);
						coluna = (int) (Math.random() * 15);

					}
				} while (doesntFits == true);
				for (int j = linha; j < linha + 5; j++) {
					tabuleiro[j][coluna] = 1;
				}
			}

		}

	}

	// DONE
	private void setCruzador() {
		for (int i = 0; i < 5; i++) {
			if ((int) (Math.random() * 3) < 2) {
				// horizontal
				int linha = (int) (Math.random() * 10);
				int coluna = (int) (Math.random() * 13);
				// muda o tabuleiro
				boolean doesntFits;
				do {
					doesntFits = false;
					for (int j = coluna; j < coluna + 3; j++) {
						if ((tabuleiro[linha][j] == 1)
								|| (tabuleiro[linha][j] == 2)) {
							doesntFits = true;
						}
					}
					if (doesntFits == true) {
						linha = (int) (Math.random() * 10);
						coluna = (int) (Math.random() * 13);
					}
				} while (doesntFits == true);
				for (int j = coluna; j < coluna + 3; j++) {
					tabuleiro[linha][j] = 2;
				}
			} else {
				// vertical
				int linha = (int) (Math.random() * 8);
				int coluna = (int) (Math.random() * 15);
				// muda o tabuleiro
				// testa se sobrepoe
				boolean doesntFits;
				do {
					doesntFits = false;
					for (int j = linha; j < linha + 3; j++) {
						if (tabuleiro[j][coluna] == 1
								|| tabuleiro[j][coluna] == 2)
							doesntFits = true;
					}
					if (doesntFits == true) {
						linha = (int) (Math.random() * 8);
						coluna = (int) (Math.random() * 15);

					}
				} while (doesntFits == true);
				for (int j = linha; j < linha + 3; j++) {
					tabuleiro[j][coluna] = 2;
				}
			}

		}

	}

	// DONE
	private void setSubmarino() {

		for (int i = 0; i < 5; i++) {
			if ((int) (Math.random() * 3) < 2) {
				// horizontal
				int linha = (int) (Math.random() * 10);
				int coluna = (int) (Math.random() * 12);
				// muda o tabuleiro
				boolean doesntFits;
				do {
					doesntFits = false;
					for (int j = coluna; j < coluna + 4; j++) {
						if ((tabuleiro[linha][j] == 1)
								|| (tabuleiro[linha][j] == 2
										|| tabuleiro[linha][j] == 3)) {
							doesntFits = true;
						}
					}
					if (doesntFits == true) {
						linha = (int) (Math.random() * 10);
						coluna = (int) (Math.random() * 12);
					}
				} while (doesntFits == true);
				for (int j = coluna; j < coluna + 4; j++) {
					tabuleiro[linha][j] = 3;
				}
			} else {
				// vertical
				int linha = (int) (Math.random() * 7);
				int coluna = (int) (Math.random() * 15);
				// muda o tabuleiro
				// testa se sobrepoe
				boolean doesntFits;
				do {
					doesntFits = false;
					for (int j = linha; j < linha + 4; j++) {
						if (tabuleiro[j][coluna] == 1
								|| tabuleiro[j][coluna] == 2
								|| tabuleiro[j][coluna] == 3)
							doesntFits = true;
					}
					if (doesntFits == true) {
						linha = (int) (Math.random() * 7);
						coluna = (int) (Math.random() * 15);

					}
				} while (doesntFits == true);
				for (int j = linha; j < linha + 4; j++) {
					tabuleiro[j][coluna] = 3;
				}
			}

		}

	}

	
	// DONE
	public void showMap(Jogador jog) {
		// VERSION
		// 1 CPU - MAPA COM NEVOA
		// 2 CPU - MAPA COM PARTES REVELADAS
		// 3 PLAYER - MAPA COMPLETO
		// ELSE - DO NOTHING

		if (jog.getID() == 1) {
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					System.out.print(" | .");
				}
				System.out.print(
						" |\n -------------------------------------------------------------\n");
			}

		} else if (jog.getID() == 2) {
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					if (tabuleiro[i][j] == 0) {
						System.out.print(" | ~");
					} else if (tabuleiro[i][j] == 1) {
						System.out.print(" | P");
					} else if (tabuleiro[i][j] == 2) {
						System.out.print(" | C");
					} else {
						System.out.print(" | S");
					}
				}
				System.out.print(
						" |\n -------------------------------------------------------------\n");
			}
		}

	}
}
