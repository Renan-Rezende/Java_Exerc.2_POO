package personagens;

public class DragaoAlado extends Personagem {
	public DragaoAlado(int vida, int escudo) {
		   super(vida, escudo);
		   this.nome = "Dragão Alado";
	   }
	
	public void falar() {
		System.out.println("O poder de Demacia prevalecera!");
	}
	
}
