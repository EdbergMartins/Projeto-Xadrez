package application;

import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		
		while (true) {
			Interface.imprimirTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			PosicaoXadrez origem = Interface.lerPosicaoXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			PosicaoXadrez destino = Interface.lerPosicaoXadrez(sc);
			
			PecaXadrez captuPecaXadrez = partida.performMovimentoXadrez(origem, destino);
			
	}

}
}