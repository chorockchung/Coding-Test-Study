import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	
	static void makeDP(int[][] dp, String str1, String str2, int len1, int len2) {
		for(int i = 0; i < len1+1; i++) { //0 초기화
			dp[i][0] = 0;
		}
		for(int j = 0; j < len2+1; j++) {
			dp[0][j] = 0;
		}
		
		for(int i = 1; i < len1 + 1; i++) {
			for(int j = 1; j < len2 + 1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}		
	}

	static int lcs(int[][] dp, String str1, String str2, int len1, int len2) {
		int i = len1, j = len2;
		StringBuilder sb = new StringBuilder();
		while(i > 0 && j > 0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				sb.append(str1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] < dp[i][j-1]) 
				j--;
			else
				i--;
		}
		
		return sb.length();
	}
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] dp = new int[len1+1][len2+1];
		
		makeDP(dp, str1, str2, len1, len2);
		int rslt = lcs(dp, str1, str2, len1, len2);
		
		System.out.println(rslt);
	}
}
