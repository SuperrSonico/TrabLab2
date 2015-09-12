package br.unisinos;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


	public static void main(String[] args) {
		Tabuleiro tb = new Tabuleiro();
		Jogo game=new Jogo("Vinicius");
		Jogador cpu=new Jogador();
		tb.showMap(cpu);
		game.iniciaJogo();
		
	}

}
