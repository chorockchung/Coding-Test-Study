import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long[] dp;

    public static void makeDP(int n) {
    	dp[0] = dp[1] = 1;
    	int i = 2;
    	while(i < n + 2) {
    		dp[i] = dp[i-2] + dp[i-1];
    		i++;
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 2];
        makeDP(n);
        System.out.println(dp[n+1]*2);
    }
}

