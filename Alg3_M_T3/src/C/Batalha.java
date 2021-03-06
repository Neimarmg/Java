package C;

import java.util.InputMismatchException;

import C.Inimigo;
import M.MapaMod;
import M.NiveisMod;
import V.View;

/**
 * Classe de execu��o do jogo, bem como controladora de passagens de fase
 * @author Neimar, Aur�lio
 */
public class Batalha {
	private static int addn = 0;
	int n1=0, n2=0, n3=0,n4=0;
	
	Inimigo inimigo = new Inimigo();
	MapaMod mapaMod = new MapaMod();
	PrintMapa printMapa =  new PrintMapa();
	PrintNiveis printNavios = new PrintNiveis();
	Estrategia estrategia = new Estrategia();
	
	
	/**
	 * M�todo de inicializa��o do mapaMod na fase 1
	 * @throws Exception
	 */
	public void iniciaMapa() throws Exception {
		addn++;
		MapaMod.setLinha(NiveisMod.getMapanivel1());
		MapaMod.setColuna(NiveisMod.getMapanivel1());
		MapaMod.criaMapa();
		printNavios.executa(true, NiveisMod.getNivel1());
		printMapa.imprime(true,"");
	}
	
	
	/**
	 * M�todo de execu��o a partir da 2� fase. Avan�a para pr�ximo n�vel
	 * @throws Exception
	 */
	protected void pulaFase() throws Exception {			
		
		if (addn == NiveisMod.getNivel2()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel2());
			MapaMod.setColuna(NiveisMod.getMapanivel2());
			MapaMod.criaMapa();
			printNavios.executa(true, NiveisMod.getNivel2());
			printMapa.imprime(true,"");	
		}
		
		
		if (addn == NiveisMod.getNivel3()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel3());
			MapaMod.setColuna(NiveisMod.getMapanivel3());
			MapaMod.criaMapa();
			printNavios.executa(true, NiveisMod.getNivel3());
			printMapa.imprime(true,"");
		}
		
		
		if (addn == NiveisMod.getNivel4()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel4());
			MapaMod.setColuna(NiveisMod.getMapanivel4());
			MapaMod.criaMapa();
			printNavios.executa(true, NiveisMod.getNivel4());
			printMapa.imprime(true,"");		
		}
		
		
		if (addn == NiveisMod.getNivel5()) {			
			MapaMod.setLinha(NiveisMod.getMapanivel5());
			MapaMod.setColuna(NiveisMod.getMapanivel5());
			MapaMod.criaMapa();
			printNavios.executa(true, NiveisMod.getNivel5());
			printMapa.imprime(true,"");		
		}		
	
	}
	
	
	public static int getAddn() {
		return addn;
	}
	
	
	/**
	 * M�todo de processamento de estrat�gia
	 * @throws Exception
	 */
	protected void executaFase() throws Exception {
		printMapa.setLetra('A');
		pulaFase();
		Estrategia.setNivel(getAddn());
		estrategia.tatica();
	}
	
	
	/**
	 * Imprime mensagem quando o jogador passou de n�vel
	 * @param nroFase
	 * @throws Exception
	 */
	protected void informaVitoria(int nroFase) throws Exception {	
		View.msgb("PARAB�NS, VOC� VENCEU A FASE " + addn);
	}
	
	/**
	 * Avalia��o para passagem das fases
	 * @throws Exception
	 */
	protected void avalia() throws Exception {		
		
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton1()) {			
			if (n1 == 0) {
				n1++;
				informaVitoria(addn);
				addn++;					
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton2()) {			
			if (n2 == 0) {
				n2++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}		
		if (Inimigo.getAcertos() == NiveisMod.getPonton3()) {
			if (n3 == 0) {	
				n3++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton4()) {
			if (n4 == 0) {
				n4++;
				informaVitoria(addn);
				addn++;	
				executaFase();
			}
		}
		
		if (Inimigo.getAcertos() == NiveisMod.getPonton5()) {
			View.msge(
				"\n\nPARAB�NS, VOC� VENCEU A FASE 5\n"
				+ "SUPEROU TODOS OS DESAFIOS PROPOSTOS NO JOGO.\n");
		}
	}
	
	
	/**
	 * Contador de chances que o jogador ainda tem durante o jogo
	 * @throws Exception
	 */
	public void contaFase() throws Exception {
		
		if (Inimigo.getChances() >0) {
			View.msg("Chances: " + Inimigo.getChances() +"\nPontua��o: " + Inimigo.getAcertos());
			avalia();
		} else {
			View.msg("\nChances: " + Inimigo.getChances() + "\nPontua��o: " + Inimigo.getAcertos());
			View.msge(					
				"\nVOC� PERDEU O JOGO.\n"
				+ "Suas chances de jogo foram esgotadas.\n"
				+ "Inicie o jogo novamente.\n");				
		}			
	}

	
	/**
	 * M�todo respons�vel pela capta��o da coordenada
	 * @throws Exception
	 */
	public void atira() throws Exception {
		try {
			View.msgl();
			inimigo.ValidaAlvo(View.digitaNumero("Nro. linha"),
			View.digitaNumero("Nro. coluna" ),"O");
		} catch (InputMismatchException e) {
			View.msgb("Era esperado um d�gito como coordenada!");
		}
		contaFase();
	}

}