import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void print(String str) {
		for(int i = 'a'; i <= 'z'; i++) {
			System.out.print(str.indexOf(i) + " ");
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		try {
			str = br.readLine();
			print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}