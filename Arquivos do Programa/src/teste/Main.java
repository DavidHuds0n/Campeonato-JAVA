package teste;

import classes.*;

public class Main {
	
	public static void main(String[] args) {
		final String GREEN = "\u001B[32m";
		final String RESET = "\u001B[0m";
		
		Clube clube1 = new Clube("Lebre");
		Clube clube2 = new Clube("Morcego");
		Clube clube3 = new Clube("Abutre");
//		Clube clube4 = new Clube("Tigre");
//		Clube clube5 = new Clube("Leão");
		
		Campeonato campeonato = new Campeonato();
		
		campeonato.inserirClube(clube1);
		campeonato.inserirClube(clube2);
		campeonato.inserirClube(clube3);
//		campeonato.inserirClube(clube4);
//		campeonato.inserirClube(clube5);
		
		campeonato.jogarCampeonato();
		String rank = campeonato.getClassificacao();
		
		System.out.println(GREEN + "[RANK FINAL]" + RESET);
		System.out.println(rank);
		System.out.println("\nParabéns ao campeão " + campeonato.getCampeao().nome + "!");
		
		
		
		
	}
}
