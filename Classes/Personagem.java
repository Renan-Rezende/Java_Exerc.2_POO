package personagens;
import armas.*;
import interfaces.*;

//"Classe m�e dos personagens" a qual todas as armas v�o erdar suas propriedades
public class Personagem implements PersonagemInterface {
	 public Arma armaEquipada;
	 public int vida;
	 public int escudo;
	 public String nome;
	 
	 public Personagem(int vida, int escudo) {
		 this.vida = vida;
		 this.escudo = escudo;
	 }
	 
	 // Fun��o atacar (somente o drag�o pode equipar a "Bola de fogo")	 
	 public void equiparArma(Arma arma) {
		 if(!"Drag�o Alado".equals(nome)) { // -> verifica se o personagem n�o � o drag�o
			 if("Bola de fogo".equals(arma.nome)) { // -> se ele n�o for o drag�o e tentar equipar a bola de fogo, retorna um aviso e n�o equipa a arma
			    System.out.println("Apenas o drag�o pode equipar a bola de fogo");
			 } else { // -> se ele n�o for o drag�o e tentar equipar qualquer outra arma, equipa a arma
				 armaEquipada = arma;
				 System.out.println(arma.nome +" equipada com sucesso!");
			 }
		 } else { 	 // -> se o personagem for o drag�o ele consegue equipar qualquer arma 
			 armaEquipada = arma;
			 System.out.println(arma.nome + " equipada com sucesso!");
		 }
		   
	 };
     // Fun��o atacar
	 // -> 1� verifica se o personagem possui uma arma 
     // -> 2� verifica se o personagem ja esta morto 
	 // -> 3� verifica se o personagem � uma mago e ataca, pois os magos bloqueiam 3 de dano (condi��o de ataque diferente) 
	 // -> 4� ataque do personagem
	 public void atacar(Personagem personagem) {
/*1�*/   if(armaEquipada == null) {
	    	 System.out.println( nome + " desarmado. Equipe uma arma antes de lutar!");
/*2�*/   } else if(personagem.vida == 0) {
	    	 System.out.println("O personagem j� esta morto");
/*3�*/   } else if(personagem.nome == "Mago") {
			      personagem.vida += 3 ;
			      armaEquipada.atacar(personagem);
			      System.out.println("A magia do mago bloqueou 3 de dano ;(");
			      if(personagem.vida <= 0) {
			          System.out.println("O mago morreu!");
			      }
/*4�*/   } else if(armaEquipada != null) {
		        armaEquipada.atacar(personagem);
		        if(personagem.vida <= 0) { // -> se o personagem for atacado e ficar com "vida <= 0" ele morre
			         System.out.println("O personagem " + personagem.nome + " morreu!");
			      }
	     } 
		 
	     
     }  
	 
	 // Fun��o andar
	 public void andar(String direcao, int unidades) {
		 System.out.println(nome + " andou " + unidades + " unidades para " + direcao);
	 }	
	 // Fun��o correr
	 public void correr(String direcao) {
		 System.out.println(nome + " correu " + 20 + " unidades para " + direcao);
	 }
	 // Fun��o voar (Somente o dragao pode voar)
	 public void voar(String direcao, int unidades) {
		 if(!(nome == "Drag�o Alado")) {
			 System.out.println(nome + " n�o pode voar! Apenas o Drag�o Alado.");
		 } else {
			 System.out.println(nome + " voou para " + direcao + " " + unidades);
		 }
	 }
	 
	 // Fun��o falar
	 public void falar() {
		 System.out.println();
	 }
	 
	// Fun��o falar --> Caso o personagem n�o tenha uma arma retorna um aviso
	 public void mostrarArma() {
		 if(armaEquipada == null) {
			 System.out.println(nome + " esta desarmado! Arme-o imediatamente!");
		 } else {
			 System.out.println("Arma do " + nome + ": " + armaEquipada.nome );
		 }
		 
	 }
	 
}
