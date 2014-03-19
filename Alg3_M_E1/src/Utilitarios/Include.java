package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import Aplicacao.Interface;

public class Include {
	
	Formatos i = new Formatos();
	
	/**Insere novo regitro em aquivo .txt
	 * @param arquivo
	 * @param desc
	 */
	public void novoRegistro(String arquivo, String  desc){
		try {
			FileWriter f;
			BufferedWriter buff;
			f = new FileWriter(new File(arquivo),true);
			buff = new BufferedWriter(f);			
			buff.newLine();
			buff.write(desc);			
			buff.close();	
		} catch (IOException e) {
			i.msg("N�o foi possiv�l inserir registro!");
		}	
	}
		
	
	/**Realiza a remo��o l�gica do registro 
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void removeRegistro(String arquivo, String  desc) throws IOException{
		String s = "";  

		try {                      
			FileReader f = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(f);
			String linha = br.readLine();
			while(linha != null ){
				linha = br.readLine();
				if(linha.equals(desc)){
					i.msg("\nRegistro encotrado:" +linha);
					br.reset();
					if(linha.equals("")){
						i.msg("\nRegistro exclu�do com sucesso:" +desc);
					}				
				}
			}
			br.close();			
		}catch(IOException e){
			i.msg("\nN�o foi possiv�l remover o registro!");
		}catch(NullPointerException e){
			i.msg("\nN�o foi possiv�l remover o registro!");
		}
	}  
		
				
	public void salva(){
		/** Realiza a remo��o l�gica do registro
		* 
		*/
	} 
		
	
	public void altera(){
		/** Realiza a remo��o l�gica do registro
		* 
		*/
	} 
}
