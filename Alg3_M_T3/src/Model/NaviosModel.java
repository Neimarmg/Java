
package Model;

public class NaviosModel {
	
	private static int portaAvioes = 1;
	private static int UnidPortaAvioes = 5;

	private static int destroyers = 2;
	private static int UnidDestroyers = 4 ;
	
	private static int fragatas  = 3;
	private static int UnidFragatas  = 3 ;
	
	private static int torpedeiros = 5;
	private static int UnidTorpedeiros = 2 ;
	
	private static int submarinos = 5;
	private static int UnidSubmarinos  = 1 ;
	
	//=================<<portaAvioes>>=================


	public static void setPortaAvioes(int portaAvioes) {
		NaviosModel.portaAvioes = portaAvioes;
	}
	
	public static int getPortaAvioes() {
		return portaAvioes;
	}
	
	public static void setUnidPortaAvioes(int unidPortaAvioes) {
		UnidPortaAvioes = unidPortaAvioes;
	}
	
	public static int getUnidPortaAvioes() {
		return UnidPortaAvioes;
	}
	

		
	//=================<< destroyers >>==================
	
	public static void setDestroyers(int destroyers) {
		NaviosModel.destroyers = destroyers;
	}
	
	public static int getDestroyers() {
		return destroyers;
	}
	
	public static void setUnidDestroyers(int unidDestroyers) {
		UnidDestroyers = unidDestroyers;
	}
	
	public static int getUnidDestroyers() {
		return UnidDestroyers;
	}
		
	//=================<< fragatas >>====================
	
	public static void setFragatas(int fragatas) {
		NaviosModel.fragatas = fragatas;
	}
	
	
	public static int getFragatas() {
		return fragatas;
	}
		
	public static void setUnidFragatas(int unidFragatas) {
		UnidFragatas = unidFragatas;
	}
	
	public static int getUnidFragatas() {
		return UnidFragatas;
	}
	
	
	//=================<< torpedeiros >>==================
	
	public static void setTorpedeiros(int torpedeiros) {
		NaviosModel.torpedeiros = torpedeiros;
	}
	
	public static int getTorpedeiros() {
		return torpedeiros;
	}
	
	public static void setUnidTorpedeiros(int unidTorpedeiros) {
		UnidTorpedeiros = unidTorpedeiros;
	}
	
	public static int getUnidTorpedeiros() {
		return UnidTorpedeiros;
	}
	
	//=================<< submarinos >>==================
	
	public static void setSubmarinos(int submarinos) {
		NaviosModel.submarinos = submarinos;
	}
	
	public static int getSubmarinos() {
		return submarinos;
	}
	
	public static void setUnidSubmarinos(int unidSubmarinos) {
		UnidSubmarinos = unidSubmarinos;
	}
	
	public static int getUnidSubmarinos() {
		return UnidSubmarinos;
	}
}
