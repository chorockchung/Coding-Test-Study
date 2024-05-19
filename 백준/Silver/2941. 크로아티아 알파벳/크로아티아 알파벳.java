import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int func(String str) {
		String[] s = {"c=", "c-", "d-" , "s=", "dz=", "lj", "nj", "z="};
		
		for(int i = 0; i < s.length; i++) {
			str= str.replace(s[i], "*");
		}

		return str.length();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		System.out.print(func(str));
	}
}