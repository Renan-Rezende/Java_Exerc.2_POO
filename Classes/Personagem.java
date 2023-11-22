package personagens;
import armas.*;
import interfaces.*;

// "Classe mãe dos personagens" a qual todas as armas vão erdar suas propriedades
//  A classe Personagem ja "implementa" a interface PersonagemIterface ->
//  -> logo todos os personagens que herdarem esta classe "implementam" esta interface 
public class Personagem implements PersonagemInterface {
	 public Arma armaEquipada;
	 public int vida;
	 public int escudo;
	 public String nome;
	 
	 public Personagem(int vida, int escudo) {
		 this.vida = vida;
		 this.escudo = escudo;
	 }
	 
	 // Função atacar (somente o dragão pode equipar a "Bola de fogo")	 
	 public void equiparArma(Arma arma) {
		 if(!"Dragão Alado".equals(nome)) { // -> verifica se o personagem não é o dragão
			 if("Bola de fogo".equals(arma.nome)) { // -> se ele não for o dragão e tentar equipar a bola de fogo, retorna um aviso e não equipa a arma
			    System.out.println("Apenas o dragão pode equipar a bola de fogo");
			 } else { // -> se ele não for o dragão e tentar equipar qualquer outra arma, equipa a arma
				 armaEquipada = arma;
				 System.out.println(arma.nome +" equipada com sucesso!");
			 }
		 } else { 	 // -> se o personagem for o dragão ele consegue equipar qualquer arma 
			 armaEquipada = arma;
			 System.out.println(arma.nome + " equipada com sucesso!");
		 }
		   
	 };
     // Função atacar
	 // -> 1º verifica se o personagem possui uma arma 
     // -> 2º verifica se o personagem ja esta morto 
	 // -> 3º verifica se o personagem é uma mago e ataca, pois os magos bloqueiam 3 de dano (condição de ataque diferente) 
	 // -> 4º ataque do personagem
	 public void atacar(Personagem personagem) {
/*1º*/   if(armaEquipada == null) {
	    	 System.out.println( nome + " desarmado. Equipe uma arma antes de lutar!");
/*2º*/   } else if(personagem.vida == 0) {
	    	 System.out.println("O personagem já esta morto");
/*3º*/   } else if(personagem.nome == "Mago") {
			      personagem.vida += 3 ;
			      armaEquipada.atacar(personagem);
			      System.out.println("A magia do mago bloqueou 3 de dano ;(");
			      if(personagem.vida <= 0) {
			          System.out.println("O mago morreu!");
			      }
/*4º*/   } else if(armaEquipada != null) {
		        armaEquipada.atacar(personagem);
		        if(personagem.vida <= 0) { // -> se o personagem for atacado e ficar com "vida <= 0" ele morre
			         System.out.println("O personagem " + personagem.nome + " morreu!");
			      }
	     } 
		 
	     
     }  
	 
	 // Função andar
	 public void andar(String direcao, int unidades) {
		 System.out.println(nome + " andou " + unidades + " unidades para " + direcao);
	 }	
	 // Função correr
	 public void correr(String direcao) {
		 System.out.println(nome + " correu " + 20 + " unidades para " + direcao);
	 }
	 // Função voar (Somente o dragao pode voar)
	 public void voar(String direcao, int unidades) {
		 if(!(nome == "Dragão Alado")) {
			 System.out.println(nome + " não pode voar! Apenas o Dragão Alado.");
		 } else {
			 System.out.println(nome + " voou para " + direcao + " " + unidades);
		 }
	 }
	 
	 // Função falar
	 public void falar() {
		 System.out.println();
	 }
	 
	// Função falar --> Caso o personagem não tenha uma arma retorna um aviso
	 public void mostrarArma() {
		 if(armaEquipada == null) {
			 System.out.println(nome + " esta desarmado! Arme-o imediatamente!");
		 } else {
			 System.out.println("Arma do " + nome + ": " + armaEquipada.nome );
		 }
		 
	 }
	 
}
