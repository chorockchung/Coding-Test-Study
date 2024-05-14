import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void print(int r, String str) {
		StringBuffer rslt = new StringBuffer();
		
		for(int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			for(int j = 0; j < r; j++)
				rslt.append(a);
		}
		
		System.out.println(rslt);
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;

		try {
			n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				String[] strs = br.readLine().split(" ");
				print(Integer.parseInt(strs[0]), strs[1]);
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}