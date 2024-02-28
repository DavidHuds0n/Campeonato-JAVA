package classes;

public class Clube {
	public String nome;
	public int pontos;
	public int saldoGols;
	
	public Clube(String nomeClube) {
		this.nome = nomeClube;
		this.pontos = 0;
		this.saldoGols = 0;
	}
	
	public void ganhar(int saldoGols) {
		this.saldoGols += saldoGols;
		this.pontos += 3;
	}
	
	public void empatar(int saldoGols) {
		this.saldoGols += saldoGols;
		this.pontos += 1;
	}
	
	public void perder(int saldoGols) {
		this.saldoGols += saldoGols;
		this.pontos += 0;
	}
}
