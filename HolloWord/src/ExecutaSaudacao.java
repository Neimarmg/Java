import java.util.Scanner;

public class ExecutaSaudacao extends Saudacao {

	public static void main(String[] args) {
		Saudacao s= new Saudacao();
		
		
		
		Scanner var =new Scanner(System.in);
		
		System.out.print("Que horas s�o: ");
		s.setHora(var.nextInt());
		
		for (int i = 0; i <= 4; i++) {
			s.setResponde(i);
			s.horario();
			//System.out.print("?: ");
			var.next();


		}		


	}
}

