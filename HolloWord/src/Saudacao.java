
public class Saudacao {
	String sauda;
	int responde;
	
	
	public void setSauda(String sauda) {
		this.sauda = sauda;
	}
	public void setResponde(int responde) {
		this.responde = responde;
	}
	
	public void mesageSaudacao(String desc){
		System.out.print(desc +"\n");
	}
	
	public void bomDia(){
		switch (responde) {
			
		case 2:
			mesageSaudacao("Bom dia!");
			break;
			
		case 3:
			mesageSaudacao("Tudo bem com voc�?");
			
			break;

		case 4:
			mesageSaudacao("Tudo?");
			mesageSaudacao("E com voc�?");
			break;			
		
		}		
	}

	
	

}
