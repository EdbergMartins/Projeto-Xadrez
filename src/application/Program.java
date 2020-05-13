package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ExcecoesXadrez;
import xadrez.PartidaDeXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		
		while (true) {
			try {
				Interface.clearScreen();
				Interface.imprimirTabuleiro(partida.getPecas());
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = Interface.lerPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = Interface.lerPosicaoXadrez(sc);
				
				PecaXadrez captuPecaXadrez = partida.performMovimentoXadrez(origem, destino);
			}
			catch (ExcecoesXadrez e ) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
				
			}
	}

}
}