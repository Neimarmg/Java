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
			+ "=> T2 'Pesquisa Bin�ria'        " + Auxiliar.statusAcao(3,0) + "\n"
			+ "=> T4 'Algoritmos de Ordena��o' " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T5 'Arvores'                 " + Auxiliar.statusAcao(2,0) + "\n"
			+ "=> SAIR\n");
		}
		
		
		public static void mostarMenuApp() {		
			msgb("	O QUE VOC� DESEJA FAZER?\n\n"
			+ "=> EXECUTAR  'Executa a��es em arquivo existente'\n"
			+ "=> CONSULTAR 'Conte�do do arquivo'\n"
			+ "=> IMPRIMIR  'Imprime arquivo selecionado'\n"
			+ "=> ARQUIVO   'Propriedades de arquivo'\n"
			+ "=> SAIR\n");
		}
		
		
		/**	
		 * @throws Exception
		 */
		public static void  nomeArquivo()throws Exception {	
			msgb(
				"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
				+"=> Nome.Extens�o\n"
				+"=> SAIR\n"
			);		
		}
		
		
		/** 
		 * @throws Exception
		 */
		public static void menuArquivo()throws Exception {	
			msgb(
				"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
				+ "=> NOVO    'Cria um novo arquivo em branco'\n"
				+ "=> BUSCAR  'Busca lista de arquivos existentes'\n"
				+ "=> REMOVER 'Remove arquivo existente'\n"
				+ "=> SAIR\n"
			);		
		}
		
		
		/** 
		 * @throws Exception
		 */
		public static void menuEditarArquivo()throws Exception {	
			msgb(
				"	EDI��O DE ARQUIVO COM ESTRUTURA DE " + Auxiliar.getOpcao() + ":\n\n"	
				+ "=> NOVO     'Habilita para gravar novo registro'\n"			
				+ "=> EDITAR   'Edita dados do arquivo'\n"
				+ "=> REMOVER  'Remove logicamente o registro'\n"
				+ "=> IMPRIMIR 'Imprime dados ordenados em arquivo'\n"
				+ "=> SAIR\n"
			);		
		}
		
		
		/**
		 * @throws Exception
		 */
		public static void menuConsultaArquivo()throws Exception {	
			msgb(
				"	OP��ES PARA CONSULTAR ARQUIVO:\n\n"	
				+ "=> NAVEGAR  'Navega pelo arquivo com comando de teclado'\n"
				+ "=> NOME     'Encontra um nome espec�fico do arquivo'\n"
				+ "=> ID       'Encontra um id atrav�s de uma busca bin�ria'\n"
				+ "=> ARQUIVO  'Imprime arquivo inteiro'\n"
				+ "=> SAIR\n"
			);		
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