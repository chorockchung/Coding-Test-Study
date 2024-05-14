import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		sc.close();
		
		int cnt = 0;
		String[] words = str.split(" ");
		if(str.startsWith(" "))
			cnt += 1;
		if(str.isBlank())
			cnt = 0;
		
		System.out.print(words.length - cnt);
	}
}