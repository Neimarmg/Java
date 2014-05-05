package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Aplicacao.Menus;
import Utilitarios.Auxiliar;
import Utilitarios.Prints;

/**
 *Classe responsavel pela ondena��o de dados carregados de um arquivo 
 * @author Neimar e Aur�lio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int topo;
	int index = 0;
	int comparacoes;
	int tamanho = 34;
	long tempoExecucao;
	String vetor[] = new String[tamanho];
	String aux;
	String pivo;
	String nomeOrdenador;
	String linha;
	FileReader file;
	BufferedReader buff;

	
	/**
	 * M�todo que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException
	 */
	private void leArquivo(String nomeArquivo) throws Exception {
		
		try {
			validaArquivo = true; // Abilita de execu��o de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;
			}			
			
			for (int i = index; i < vetor.length; i++) { //Complementa o vetor ap�s carregamento dos dados do arquivo.
				vetor[i]= "";
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			validaArquivo = false; // Desabilita a execu��o de ordenador
		
		} catch (IOException e) {
			Prints.msge("\nO arquivo n�o pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espa�o insufiente no array de armazenamento.\n");
		}
	}
	
	
	/**
	 * M�tofo que exibe o cabe�alho com a ordem de execu��o, crescente ou decrescente
	 * @param ordem
	 * @param exibirCabecalho
	 */
	private  void informaCabecalhoOrdem(boolean ordem,boolean exibirCabecalho){	
		 if (exibirCabecalho == true) {
			if (ordem == true) {
	        	Prints.msgc("	ORDEM CRESCENTE "+nomeOrdenador.toUpperCase() +"\n\n");
			}else{
				Prints.msgc("	ORDEM DECRESCENTE "+nomeOrdenador.toUpperCase() +"\n\n");
			}
		 }
	}
	
	
	/**
	 * M�todo respons�vel pela limpesa do vetor ap�s ordena��o,
	 * de modo que possa ter suas posi��es livres,
	 * quando uma pr�xima ordena��o for solicitada em tempo de execu��o.
	 */
	private  void limpaVetor(boolean limparVetor){
		if(limparVetor == true){
			for (int i = 0; i < vetor.length; i++) {
				vetor[i]= "";				
			}
		}
		index = 0; //Limpa index do vetor executado anteriormente.
	}

	
//========================= << Ordena��o BubleSort >> ==============================
	
	/**
	 * M�todo respons�vel pela manipula��o do vetor, durante a ordena��o do bubleSort
	 * @param i
	 * @param j
	 */
	private void trocasItensBubleSort(int i, int j){
		aux = vetor[i];                	
        vetor[i] = vetor[j];
        vetor[j] = aux;	
	}
		
	
	/**
	 * Metodo respons�vel pela ordena��o do BubleSort
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBubleSort(boolean ordem ) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (ordem == true) {	         			
		                if (vetor[i].compareTo(vetor[j]) > 0) { // Ordem crescente  
		                   	trocasItensBubleSort(i, j);
			                comparacoes++;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { // Ordem decrescente  
		                	trocasItensBubleSort(i, j);
		                	comparacoes++;
		                }
	         		} 
	         	}	         	
	         	tempoExecucao  = System.currentTimeMillis();	         	
	         }			
	
		} catch (NullPointerException e) {
		 	Prints.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	
	/**
	 * Metodo respens�vel pelo execu��o do ordenador bubleSort
	 * @throws Exception
	 */
	private void executaBubleSort() throws Exception {
		leArquivo(Auxiliar.digita("Nome do arquivo"));
		if (validaArquivo == true){
			ordenaBubleSort(especificaOrdem(true));
		}		 
	}
		
	
	/**
	 * Metodo respens�vel pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	private void carregaBubleSort(boolean imprimir) throws Exception{
		limpaVetor(true); // Garante que o vetor limpo antes do carregamento do ordenador
		executaBubleSort();
		
		if (imprimir == true){//Abilita impress�o do vetor quando solicitado
			imprime(true,true, true, true);
		}
	}
	
	
// ======================== << Ordena��o QuickSort >> ====================================

	
	/**
	 * M�todo que partiona o vetor e ordena as partes idividualmente
	 * @param vet
	 * @param ini
	 * @param fim
	 * @return topo
	 */
	private int particionaVetorQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int i;
	    pivo = vet[ini];
	    topo = ini;
	 
	    for (i = ini + 1; i <= fim; i++) {
	    	if(ordem == true){
		    	if (vet[i].compareTo(pivo) < 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	 topo++;
			    	comparacoes++;
		    	}
		    }else{
		    	if (vet[i].compareTo(pivo) > 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	topo++;
			    	comparacoes++;
		    	}	
		    }
	    	tempoExecucao  = System.currentTimeMillis();
	     }
	    vet[topo] = pivo;
	    return topo;
	 }
	 
	
	/**
	 * M�todo que executa as etapas a ordena��o do vetor
	 * @param vet
	 * @param ini
	 * @param fim
	 */
	private void ordenaQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int meio;		
		if (ini < fim) {
			meio = particionaVetorQuickSort(vet, ini, fim, ordem);
		    ordenaQuickSort(vet, ini, meio, ordem);
		    ordenaQuickSort(vet, meio + 1, fim, ordem);
		}		
	}
	
	
	/**
	 * M�todo de carregamento e valida��o do ordenador 
	 * @throws Exception
	 */
	private void carregaQuickSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante que o vetor limpo antes do carregamento do ordenador
		leArquivo(Auxiliar.digita("Nome do arquivo"));
		
		if (validaArquivo == true){ 
			boolean ordem = especificaOrdem(true);
			ordenaQuickSort(vetor, 1, (vetor.length-2),ordem );
			
			if(imprimir == true){ //Abilita impress�o do vetor quando solicitado
				imprime(ordem, true, true, true);
			}
		}	    
	}

	
//=============== << Compara��o estat�stica de ordenadores >> ===============================
	
	/**
	 * M�todo estat�stico de compara performance dos ordenadores
	 * @throws Exception
	 */
	public  void comoparaOrdenadores() throws Exception{
		limpaVetor(true);
		nomeOrdenador = "BUBLE SORT COMPARARADA";
		carregaBubleSort(false);
		informaStatistica(true);
		limpaVetor(true);
		nomeOrdenador = "QUICK SORT COMPARARDA";
		carregaBubleSort(false);
		informaStatistica(true);
		selecionaOrdenador();
	}
	
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * Informa dados estat�sticos espec�ficos da ordena��o
	 * @param mostraEstatica
	 */
	private  void informaStatistica(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTAT�STICOS DA ORDENA��O " +nomeOrdenador.toUpperCase()
				+"\nTamanho do vetor: " +tamanho
				+"\nTotal de comparacoes: " +comparacoes
				+"\nTempo total: " +tempoExecucao +"mls\n");
		}
	}
	
	
	/**
	 * M�dodo geral de impress�o da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private  void imprime(boolean ordem, boolean mostraEstatisca, boolean limpaVetor, boolean exibecabecalho){	
		informaCabecalhoOrdem(ordem,exibecabecalho);
		for (String dados : vetor){ 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpaVetor);
	}


	/**
	 * M�todo que define a ordem de ordena��o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	private boolean especificaOrdem(Boolean ativaMenu) throws Exception{	
		Menus.menuModoOrdenacao(ativaMenu);
		String modo  = Auxiliar.digita("Ordem");
		
		if (modo.equals("c")) { //Define ordem crescente
			return true;
			
		} else if (modo.equals("d")) { //Define ordem decrescente
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return especificaOrdem(ativaMenu);
		}		
	}

	
	/**
	 * M�todo respons�vel pela sele��o dos comandos para execu�ao dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		Menus.menuOrdenadores();
		nomeOrdenador = Auxiliar.digita("");
		switch (nomeOrdenador) {			
			
		case "buble":
			carregaBubleSort(true);
			selecionaOrdenador();			
			break;
		
		case "quick":		
			carregaQuickSort(true);			
			selecionaOrdenador();
			break;
	
		case "comparar":
			comoparaOrdenadores();
			selecionaOrdenador();
			break;
			
		case "sair":
			Prints.sair();
			break;
				
		default:
			Prints.opcaoInvalida();
			selecionaOrdenador();
			break;
		}
	}
}