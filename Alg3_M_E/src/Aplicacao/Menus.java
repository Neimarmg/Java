package Aplicacao;

import model.Utilitarios.Auxiliar;

/**
 * Classe de implemeta��o de menus do todo o sistema
 * @author Neimar, Aur�lio
 */
public class Menus extends Prints {
	
		public static void menuSelecinaAtividade() {		
			msgb("	QUAL ATIVIDADE?\n\n"
			+ "=> T1 'Listas Encadeadas'       " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T2 'Pesquisa Bin�ria'        " + Auxiliar.statusAcao(7,0) + "\n"
			+ "=> T4 'Algoritmos de Ordena��o' " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T5 'Arvores'                 " + Auxiliar.statusAcao(2,0) + "\n"
			+ "=> SAIR\n");
		}
		
		
		public static void mostarMenuApp() {		
			msgb("	O QUE VOC� DESEJA FAZER?\n\n"
			+ "=> EXECUTAR  'Executa a��es nas estruturas existente'\n"
			+ "=> CONSULTAR 'Conte�do do salvo em arquivo(s)'\n"
			+ "=> IMPRIMIR  'Imprime arquivo selecionado'\n"
			+ "=> ARQUIVO   'Propriedades de arquivo'\n"
			+ "=> SAIR\n");
		}

		
		/** 
		 * M�todos respons�vel pele exibi��o dos menus de include
		 * @throws Exception
		 */
		public static void menuInclude(String include)throws Exception {	
			String menu =
					"	OP��ES DE INCLUDE\n\n"+
					"=> NOVO     'Habilita para gravar novo registro'\n"+	
					"=> REMOVER  'Remove arquivo existente'\n"+
					"=> IMPRIMIR 'Imprime dados'\n";
			
			switch (include) {
			
			case "ARQUIVO":			
				menu += "=> BUSCAR   'Busca lista de arquivos existentes'\n";
				break;
				
			case "DADOS":	
				menu += "=> EDITAR   'Edita dados do arquivo'\n";
				break;				
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}
		
		
		/**
		 * Menu global para consultas
		 * @throws Exception
		 */
		public static void menuConsultas()throws Exception {	
			String menu ="";
			
			switch (Auxiliar.getOpcao()) {
			case "ARVORE":			
				menu += "	OP��ES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> NOME  'Encontra um nome dentro da �rvore'\n";
				break;
				
			case "BINARIA":	
				menu += "	OP��ES PARA CONSULTA(S) " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> ID 'Encontra um id atrav�s de uma busca bin�ria'\n";
				break;
				
			case "LISTA":
				menu += "	OP��ES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"\n\n"
						+"=> NOME	 'Encontra um nome dentro da lista'\n"
						+"=> NAVEGAR 'Navega pelo arquivo com comando de teclado'\n"
						+"=> ARQUIVO 'Imprime arquivo inteiro'\n";
				break;
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}

		
		/**
		 * M�todo respons�vel pela execu��o das formas de ordena��o
		 * @throws Exception
		 */
		public static void menuOrdenadores()throws Exception {	
			msgb(
				"	COMO ORDENAR DADOS?\n\n"	
				+"=> BUBLE    'Ordena dados do arquivo com BubleSort'\n"
				+"=> QUICK    'Ordena dados do arquivo com QuickSort'\n"
				+"=> COMPARAR 'Imprime dados estat�sticos dos dois ordenadores \n"
				+"=> SAIR\n"
			);		
		}

		
		/**
		 * Menu de defini��o de modo de ordena��o
		 * @throws Exception
		 */
		public static void menuModoOrdenacao(boolean ativaMenu)throws Exception {	
			if (ativaMenu == true) {
				msgb(
					"	DESEJA ORDENAR PARA:\n\n"	
					+ "=> C 'Exibe arquivo na ordem crescente'\n"
					+ "=> D 'Exibe arquivo na ordem decrescente'\n"
				);
			}
		}
		
}