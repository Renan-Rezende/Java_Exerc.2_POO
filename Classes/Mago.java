package personagens;

public class Mago extends Personagem{
	public Mago(int vida, int escudo) {
		   super(vida, escudo);
		   this.nome = "Mago";
		   
	   }
	
	public void falar() {
		System.out.println("Toda magia tem um preço.");
	}
}
