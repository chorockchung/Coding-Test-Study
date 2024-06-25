import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int func(int n, int m, int[] narr, int[] marr) {
        Arrays.sort(marr);
        
        int cnt = 0;
        for (int ni = 0; ni < n; ni++) {
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (narr[ni] > marr[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            cnt += left;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] narr = new int[n];
            int[] marr = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                narr[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                marr[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(func(n, m, narr, marr)).append('\n');
        }

        System.out.println(sb);
    }
}
