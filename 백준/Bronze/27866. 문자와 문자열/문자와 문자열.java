import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int pos = sc.nextInt();
		
		System.out.print(input.charAt(pos-1));
		
		sc.close();
	}
}
