package View;

import Controller.Utilitarios.Prints;
import Model.SoldadoMod;

public class SoldadosView extends SoldadoMod {
	
	
	/**
	 * M�todo de avali��o de nome 
	 */
	public void avaliaNome(){
		if (SoldadoMod.getNomeSoldado().equals(" ")) {
			Prints.msg("\nO soldado ainda n�o possiu nome!\n");
		}else{
			Prints.msg("\nNome do jogador: " 
				+SoldadoMod.getNomeSoldado() +"\n");
		}
	}
	
	/**
	 * M�todo de avali��o da pontua��o do soldado 
	 */
	public void avaliaPontos(){
		if (SoldadoMod.getPontuacaoInicial() > 0 ) {
			Prints.msg("Pontua��o inicial: " 
				+SoldadoMod.getPontuacaoInicial() +"\n");
		}else{
			Prints.msgr("O soldado " +SoldadoMod.getNomeSoldado()
				+" n�o possui pontos para inicar o jogo!\n");
		}
	}
	
	
	public void imprime(){
		avaliaNome();
		avaliaPontos();
	}
}
