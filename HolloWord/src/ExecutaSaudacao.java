import java.util.Scanner;


public class ExecutaSaudacao extends Saudacao {

	public static void main(String[] args) {
		Saudacao s= new Saudacao();
		
		Scanner var =new Scanner(System.in);
		for (int i = 0; i <= 5; i++) {
			s.setResponde(i);
			s.bomDia();
			System.out.print("?:");
			var.next();
		}
	}

}
