import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] dp = new int[31][31]; // n과 r의 최대값을 고려하여 크기 조정

    // 조합을 계산하는 함수
    public static void combination() {
        // 기저 조건 설정
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1; // C(i, 0) = 1
            dp[i][i] = 1; // C(j, j) = 1
            if(i == 0) continue;
            dp[i][1] = i; // C(j, 1) = j
        }

        // DP 테이블 채우기
        for (int i = 3; i <= 30; i++) {
            for (int j = 2; j < i; j++) {
            	dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];                
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        combination();
        
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            sb.append(dp[b][a]).append('\n');
        }
        
        System.out.print(sb);
    }
}
