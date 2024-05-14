import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int inputLen = sc.nextInt();
		String[] strs = new String[inputLen];

		for(int i = 0; i < inputLen; i++) {
			strs[i] = sc.next();
		}

		for(int i = 0; i < inputLen; i++) {
			System.out.println(strs[i].charAt(0) + "" + strs[i].charAt(strs[i].length()-1));

		}
		sc.close();
	}
}