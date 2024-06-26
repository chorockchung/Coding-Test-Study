import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int i = 0;
        int max = 0;
        while(i < n) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max)
                max = arr[i];
            i++;
        }
        
        int mid = 0;
        int left = 0, right = max;
        while(left <= right) {
            mid = (left + right) / 2;
            
            long cnt = 0;
            for(int j = 0; j < n; j++) {
                if(arr[j] <= mid)
                    cnt += arr[j];
                else
                    cnt += mid;
            }

            if(cnt <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.print(right);
    }
}
