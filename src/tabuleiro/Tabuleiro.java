package tabuleiro;

public class Tabuleiro {
	
	private Integer linhas;
	private Integer colunas;
	private Pecas[][] pecas;
	
	
	public Tabuleiro(Integer linhas, Integer colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Pecas[linhas][colunas];
		
	}
	public Integer getLinhas() {
		return linhas;
	}
	public void setLinhas(Integer linhas) {
		this.linhas = linhas;
	}
	public Integer getColunas() {
		return colunas;
	}
	public void setColunas(Integer colunas) {
		this.colunas = colunas;
	}
	
	public Pecas peca (int linha, int coluna) {
		return pecas[linha][coluna];
		
	}
	
	public Pecas peca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	
	
}
