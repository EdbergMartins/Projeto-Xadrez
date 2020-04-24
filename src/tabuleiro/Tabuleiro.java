package tabuleiro;

public class Tabuleiro {
	
	private Integer linhas;
	private Integer colunas;
	private Pecas[][] pecas;
	
	public Tabuleiro(Integer linhas, Integer colunas) {
		if (linhas<1 || colunas <1) {
			throw new ExcecoesTabuleiro("Erro ao criar o tabuleiro:  Necessário que haja mais de 1 linha e 1 coluna"); 
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Pecas[linhas][colunas];
		
	}
	public Integer getLinhas() {
		return linhas;
	}

	public Integer getColunas() {
		return colunas;
	}

	public Pecas peca (int linha, int coluna) {
		if (!posicaoExistentes(linha, coluna)) {
			throw new ExcecoesTabuleiro("Posição fora do tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Pecas peca(Posicao posicao) {
		if (!posisoesExistentes(posicao)) {
			throw new ExcecoesTabuleiro("Posição fora do tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void lugarPeca(Pecas peca, Posicao posicao) {
		if (existeUmaPeca(posicao)) {
			throw new ExcecoesTabuleiro("Já existe uma na posicao: " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posicaoExistentes(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posisoesExistentes(Posicao posicao) {
		return posicaoExistentes(posicao.getLinha(),posicao.getColuna());
	}
	
	public boolean existeUmaPeca (Posicao posicao) {
		if (!posisoesExistentes(posicao)) {
			throw new ExcecoesTabuleiro("Posição fora do tabuleiro");
		}
		return peca(posicao)!=null;		
	}
	
}
