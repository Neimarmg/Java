package View;

import Controller.Utilitarios.Prints;
import Model.SoldadoModel;

public class SoldadosView extends SoldadoModel {
	Prints p = new Prints();
	
	/**
	 * M�todo de avali��o de nome 
	 */
	public void avaliaNome(){
		if (SoldadoModel.getNomeSoldado().equals(" ")) {
			p.msgc("O soldado ainda n�o possiu nome!\n");
		}else{
			p.msgc("Nome do jogador " 
				+SoldadoModel.getNomeSoldado() +"\n");
		}
	}
	
	/**
	 * M�todo de avali��o da pontua��o do soldado 
	 */
	public void avaliaPontos(){
		if (SoldadoModel.getPontuacaoInicial() > 0 ) {
			p.msgr("Pontua��o inicial " 
				+SoldadoModel.getPontuacaoInicial() );
		}else{
			p.msgr("O soldado " +SoldadoModel.getNomeSoldado()
				+" n�o possui pontos para inicar o jogo!\n");
		}
	}
	
	
	public void imprime(){
		avaliaNome();
		avaliaPontos();
	}
}
