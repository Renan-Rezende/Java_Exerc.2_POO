package armas;

import personagens.*;
import interfaces.*;

// "Classe mãe das armas" a qual todas as armas vão erdar suas propriedades
public class Arma implements ArmaInterface{
	 
	 public int dano; 
	 public String nome;
	 
	 public Arma() {
		 this.dano = 0;
	     this.nome = "Arma Genérica";
	 }
	 
	 public void atacar(Personagem personagem) {
	    personagem.vida += personagem.escudo - this.dano;
	    System.out.println("Atacando o " + personagem.nome + "...");
	    System.out.println("vida do " + personagem.nome + ": " + personagem.vida);
	 };
	 
	 
}
