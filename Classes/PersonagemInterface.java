package interfaces;

import personagens.*;
import armas.*;

// interface dos personagens 
public interface PersonagemInterface {
   public void equiparArma(Arma arma);
   public void atacar(Personagem personagem);
   public void falar();
   public void andar(String direcao,int unidades);
   public void correr(String direcao);
}