package application;

import xadrez.PartidaDeXadrez;

public class Program {

	public static void main(String[] args) {
		
		PartidaDeXadrez partida = new PartidaDeXadrez();
		Interface.imprimirTabuleiro(partida.getPecas());
	}

}
