package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utilitarios.Prints;

/**
 *Classe responsavel pela ondena��o de dados de arquivo 
 * @author Neimar e Aur�lio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int index = 0, trocas = 0 , tamanho = 100;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux;

	
	//Ficheiro ficheiro = new Ficheiro();
	
	/**
	 * M�todo que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	private void executaArquivo(String nomeArquivo) throws Exception {
		
		try {
			validaArquivo = true; // Abilita de execu��o de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;
				//Prints.msg(vetor[index] +"\n");
				
			}
			
			//Aumenta tamanho do vetor.
			for (int i = index; i < vetor.length; i++) {
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
	 * Exibe o cabe�alho do modo de ordena��o crescente ou decrescente
	 * @param modo
	 * @param exibecabecalho
	 */
	private  void informaCabecalhoModo(boolean modo,boolean exibecabecalho){	
		 if (exibecabecalho == true) {
			if (modo == true) {
	        	Prints.msgc("ORDEM CRESCENTE\n\n");
			}else{
				Prints.msgc("ORDEM DECRESCENTE\n\n");
			}
		 }
	}
	
	
	/**
	 * M�todo respons�vel pela limpesa do vetor ap�s ordena��o,
	 * de modo que possa ter suas posi��es livres,
	 * quando uma pr�xima ordena��o for solicitada
	 */
	private  void limpaVetor(boolean limpar){
		if(limpar == true){
			for (int i = 0; i < vetor.length; i++) {
				vetor[i]= "";
			}
		}
	}

	
	
//========================= << Ordena��o BubleSort >> ==============================
	
	/**
	 * Metodo responsavel pela ordena��o dos dados captados do arquivo
	 * @param modo
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBubleSort(boolean modo, boolean mostraEstatisca) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (modo == true) {	         			 
		                if (vetor[i].compareTo(vetor[j]) > 0) { // Ordem crescente  
		                	aux = vetor[i];                	
			                vetor[i] = vetor[j];
			                vetor[j] = aux;
			                trocas++;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { // Ordem decrescente  
		                	aux = vetor[i];                	
		                	vetor[i] = vetor[j];
		                	vetor[j] = aux;
		                	trocas++;
		                }
	         		} 
	         	}
	         }	         	 
			imprimeOrdenacao(modo,mostraEstatisca,true,true);
		} catch (NullPointerException e) {
			Prints.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	
	
// ======================== << Ordena��o QuickSort >> ====================================
	
	/**
	 * Metodo reponsavel para o particionamento do vetor
	 * @param vet
	 * @param inicio
	 * @param fim
	 * @return
	 */
    public int perticionaVetor(String vet[], int inicio, int fim) {
        String pivoInicio; 
        int i, pivoFim;
        
        pivoInicio = vetor[inicio];
        pivoFim = inicio;
        
        Prints.msg("\npivoInicio " +vetor[inicio] +"\n");
        
        for (i = pivoFim + 1; i <= fim; i++) {
            if (vetor[i].compareTo(vet[i]) > pivoInicio.compareTo(pivoInicio)) {
                vetor[pivoFim] = vetor[i];
                vetor[i] = vetor[pivoFim + 1];
                pivoFim++;
                trocas++;
            }
        }
        
        vetor[pivoFim] = pivoInicio;
        Prints.msg("\npivoFim " +pivoFim +"\n");
        return pivoFim;
    }
 
    
    /**
     * M�todo de execu��o do ordenador
     * @param vet
     * @param inicio
     * @param fim
     */
	public void executaQuickSort(String vet[], int inicio, int fim) {
        int meio;
        
        if (inicio < fim) {
            meio = perticionaVetor(vet, inicio, fim);
            Prints.msgr("\nMeio " +meio);
            executaQuickSort(vet, inicio, meio);
            executaQuickSort(vet, meio + 1, fim);
           
        }        
    }   
    
	
	/**
	 * M�todo repons�vel pelo carregamento do erdenador
	 * @throws Exception
	 */
    public void carregaQuickSort() throws Exception {
    	executaArquivo("l.txt" /*Prints.digita("Nome do arquivo"))*/);
    	if (validaArquivo == true){
    		executaQuickSort(vetor, 1, (vetor.length - 1));
    		imprimeOrdenacao(true, true, false, true);
    	} 
    }
	 
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * Informa dados estat�sticos espec�ficos da ordena��o
	 * @param mostraEstatica
	 */
	private  void informaStatistica(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTAT�STICOS DA ORDENA��O\n"
				+"\nTamanho do vetor: " +tamanho
				+"\nTotal de trocas: " +trocas
				+"\nTempo total: \n" );
		}
	}
	
	
	/**
	 * M�dodo de impress�o da lista de dados dos ordenadores
	 * @param modo
	 * @param mostraEstatisca
	 * @param limpar
	 * @param exibecabecalho
	 */
	private  void imprimeOrdenacao(boolean modo,boolean mostraEstatisca,boolean limpar,boolean exibecabecalho){	
		informaCabecalhoModo(modo,exibecabecalho);
		for (String dados : vetor){ 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpar);
	}


	/**
	 * M�todo que define o modo de ordena��o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	private boolean defineModoOrdencao() throws Exception{	
		Prints.menuModoOrdenacao();
		String modo  = Prints.digita("Modo");
		
		if (modo.equals("c")) {
			return true;
			
		} else if (modo.equals("d")) {
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return defineModoOrdencao();
		}		
	}

	
	
	/**
	 * M�todo respons�vel pela sele��o dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		Prints.menuOrdenadores();				
		switch ("quick" /*Prints.digita("")*/) {			
			
		case "buble":
			executaArquivo(Prints.digita("Nome do arquivo"));
			if (validaArquivo == true){
				ordenaBubleSort(defineModoOrdencao(),true);
			}
			selecionaOrdenador();			
			break;
		
		case "quick":		
			carregaQuickSort();			
			//selecionaOrdenador();
			break;
	
		case "comparar":		
		
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