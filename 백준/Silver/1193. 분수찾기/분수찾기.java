import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp;

    public static int makeDP(int n) {
    	int i = 1;
    	dp[1] = 1;
    	while(dp[i] < n) {
    		dp[i + 1] = dp[i] + i;
    		i++;
    	}
    	
    	return i;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        dp = new int[x+1];
        int point = makeDP(x);

        if(dp[point] == x) {
        	if(point % 2 != 0)
        		System.out.println(point + "/" + 1);
        	else
        		System.out.println(1 + "/" + point);
        }
        else {
        	int before = point - 1;
        	int step = x - dp[before];
        	if(before % 2 != 0)
        		System.out.println((before - step) + "/" + (1 + step));
        	else
        		System.out.println((1 + step) + "/" + (before - step));

        }
       
    }
}

