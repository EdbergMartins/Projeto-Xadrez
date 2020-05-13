package xadrez;



import tabuleiro.ExcecoesTabuleiro;
import tabuleiro.Pecas;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		configuracaoInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		
		return mat;
	}
	
	public PecaXadrez performMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.converterPosicao();
		Posicao destino = posicaoDestino.converterPosicao();
		validacaoPosicaoDeOrigem(origem);
		Pecas pecaCapturada = makeMove(origem, destino);
		return (PecaXadrez) pecaCapturada;
	}
	
	private Pecas makeMove (Posicao origem, Posicao destino) {
		Pecas p = tabuleiro.removerPeca(origem);
		Pecas capturaPecas = tabuleiro.removerPeca(destino);
		tabuleiro.lugarPeca(p, destino);
		return capturaPecas;
	}
	
	private void validacaoPosicaoDeOrigem (Posicao posicao) {
		if (!tabuleiro.existeUmaPeca(posicao)) {
			throw new ExcecoesTabuleiro("Não existe peça na posicao de origem") ;
		}
	}
	
	private void lugarNovaPeca (char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).converterPosicao());
	
	}
	
	private void configuracaoInicial() {
		lugarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        lugarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
