package classes;

import java.util.ArrayList;
import classes.Clube;

public class Campeonato {
	public ArrayList<Clube> clubes; 
	static int contPartida = 1;
	
	public Campeonato() {
		this.clubes = new ArrayList<>();
	}
	
	public void inserirClube(Clube clube) {
        this.clubes.add(clube);
    }
	
	public void jogarCampeonato() {
		for(int i = 0 ; i < this.clubes.size() ; i++) {
			for(int j = 0 ; j < this.clubes.size() ; j++) {
				if(i == j) {
					continue;
				}
				else {
					jogarPartida(this.clubes.get(i), this.clubes.get(j));
				}
			}
		}
	}
	
	private void jogarPartida(Clube a, Clube b) {
		final String YELLOW = "\u001B[33m";
		final String RESET = "\u001B[0m";
		
		int golsA = (int) (Math.random() * 6);
		int golsB = (int) (Math.random() * 6);
		
		int saldoA = golsA - golsB;
		int saldoB = golsB - golsA;
		
		System.out.println(YELLOW + "[PARTIDA " + contPartida + "]" + RESET);
		System.out.println("Gols de: " + a.nome + " " + golsA);
		System.out.println("Gols de: " + b.nome + " " + golsB);
		System.out.println("Saldo de: " + a.nome + " " + saldoA);
		System.out.println("Saldo de: " + b.nome + " " + saldoB + "\n");
		
		if(golsA > golsB) {
			a.ganhar(saldoA);
			b.perder(saldoB);
			
			System.out.print("Pontos de " + a.nome + ": " + a.pontos + "\nPontos de: " + b.nome + " " + b.pontos + "\n");
			System.out.print("Saldo de " + a.nome + ": " + a.saldoGols + "\nSaldo de: " + b.nome + " " +  b.saldoGols + "\n\n");
		}
		else if(golsA < golsB) {
			a.perder(saldoA);
			b.ganhar(saldoB);
			
			System.out.print("Pontos de " + a.nome + ": " + a.pontos + "\nPontos de: " + b.nome + " " + b.pontos + "\n");
			System.out.print("Saldo de " + a.nome + ": " + a.saldoGols + "\nSaldo de: " + b.nome + " " +  b.saldoGols + "\n\n");
		}
		else {
			a.empatar(saldoA);
			b.empatar(saldoB);
			
			System.out.print("Pontos de " + a.nome + ": " + a.pontos + "\nPontos de: " + b.nome + " " + b.pontos + "\n");
			System.out.print("Saldo de " + a.nome + ": " + a.saldoGols + "\nSaldo de: " + b.nome + " " +  b.saldoGols + "\n\n");
		}
		contPartida += 1;
	}
	
	public String getClassificacao() {
		for(int i = 0 ; i < this.clubes.size() ; i++) {
			for(int j = i + 1 ; j < this.clubes.size() ; j++) {
				Clube clube1 = this.clubes.get(i); 
				Clube clube2 = this.clubes.get(j);
				
				if(clube1.pontos < clube2.pontos || (clube1.pontos == clube2.pontos && clube1.saldoGols < clube2.saldoGols)) {
				    this.clubes.set(i, clube2); 
				    this.clubes.set(j, clube1);
				}
			}
		}
		
		StringBuilder rank = new StringBuilder();
        rank.append("");
        for (int i = 0; i < this.clubes.size(); i++) {
            rank.append(this.clubes.get(i).nome + " - Pontos: " + this.clubes.get(i).pontos + ", Saldo: " + this.clubes.get(i).saldoGols);
            if (i < this.clubes.size() - 1) {
                rank.append("\n");
            }
        }
        rank.append("");
        return rank.toString();
	}
	
	public Clube getCampeao() {
		return this.clubes.get(0);
	}
}
