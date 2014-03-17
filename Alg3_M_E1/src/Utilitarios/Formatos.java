package Utilitarios;

public class Formatos {	
	
	public void msg(Object desc){
		// imprime na tale mem�ria dispPlanejamento inicial    
		System .out.print(desc);
	}
	
	
	public void msgb(Object desc){
		System .out.print(
			"\n====================================================\n"
			+desc
			+"\n====================================================\n");
	}
	
	
	public void msgl(){
		System .out.print(
			"\n====================================================\n");
	}
	
	
	public void msgOpcaoInvalida(){
		System .err.print("\nOp��o de comando inv�lido. Tente novamente!\n");
	}
	
	
	public void msgNaoImplementado(){
		System .err.print("\nN�o implementado!\n");
	}
	
	public void msgDigitaComando(){
		System .out.print("\nCOMANDO: ");;
	}
	
	
	public void msgSair(){
		
		System.err.print("\nVoc� optou por sair do programa\n"
				+ "Obrigado!!!");;
	}
	
	
	public void menuInsert() throws Exception {
		msgb(
			"	GRAVAR DADOS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> LISTA\n"
			+"=> AMBAS\n"
			+"=> SAIR\n"
		);			
	}
	
	
	public void menuConsultas()throws Exception {	
		System .out.print(
			"	CONSULTAS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> nLISTA\n"
			+"=> nSAIR\n"
		);		
	}
	
	
	public void menuImprimir()throws Exception {	
		msgb(
			"	MENU OP��ES DE IMPRESS�O:\n\n"	
			+"=> ARQUIVO\n"
			+"=> LISTA\n"
			+"=> AMBOS\n"
			+"=> SAIR\n"
		);		
	}
	
	
	public void  nomeArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> Nome.txt\n"
			+"=> SAIR\n"
		);		
	}
	
	
	public void menuArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> NOVO\n"
			+"=> BUSCAR\n"
			+"=> REMOVER\n"
			+"=> SAIR\n"
		);		
	}
	
}