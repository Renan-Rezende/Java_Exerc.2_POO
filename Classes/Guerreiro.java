package personagens;

public class Guerreiro extends Personagem{
   public Guerreiro(int vida, int escudo) {
	   super(vida, escudo);
	   this.nome = "Guerreiro";
   }
   
   public void falar() { 
	  System.out.println("Vamos a batalha!");
   }
   
}
