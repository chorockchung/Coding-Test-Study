import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();

		int rslt = 0;
		for(int i = 0; i < n; i++) {
			rslt += str.charAt(i) - '0';
		}
		
		System.out.print(rslt);
		sc.close();
	}
}