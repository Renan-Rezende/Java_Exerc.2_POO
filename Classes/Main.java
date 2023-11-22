package personagens;
import armas.*;


public class Main {
	public static void main(String[] args) {
		
		// Criando os personagens == criando suas instâncias
		Guerreiro guerreiro = new Guerreiro(30, 7);
		Mago mago = new Mago(20,3);
		DragaoAlado dragaoAlado = new DragaoAlado(50,10);
		
		// Criando as armas == criando suas instâncias
		Faca faca = new Faca();
		BolaDeFogo bolaDeFogo = new BolaDeFogo();
		
		// Equipando as armas nos personagens
		dragaoAlado.equiparArma(bolaDeFogo);
		guerreiro.equiparArma(faca);
	
		// Mostrando o nome das Armas dos personagens 
		dragaoAlado.mostrarArma();
		guerreiro.mostrarArma();
		
		// Falas dos personagens
		dragaoAlado.falar();
		guerreiro.falar();
		mago.falar();

		// "Simulando" uma batalha 
		
		guerreiro.atacar(mago);
		mago.atacar(guerreiro);
		dragaoAlado.atacar(mago);													
		
	}
}
