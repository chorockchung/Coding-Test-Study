import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] pattern = br.readLine().split("\\*");
		int patternLen = pattern[0].length() + pattern[1].length();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(str.length() < patternLen)
				sb.append("NE").append("\n");
			else if(str.indexOf(pattern[0]) == 0 && str.lastIndexOf(pattern[1]) == str.length()-pattern[1].length()) 
				sb.append("DA").append("\n");
			else
				sb.append("NE").append("\n");
		}
		
		System.out.print(sb);
	}
}