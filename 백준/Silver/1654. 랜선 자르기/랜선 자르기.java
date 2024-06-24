import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[n];
        int i = 0;
        long max = 0;
        while(i < n) {
        	arr[i] = Long.parseLong(br.readLine());
        	if(arr[i] > max)
        		max = arr[i];
        	i++;
        }
        
        long mid = 0;
        long left = 0, right = max;
        while(left <= right) {
        	mid = (left + right)/2;
        	if(right == 1)
        		mid = 1;
        	
        	int cnt = 0;
        	for(int j = 0; j < n; j++) {
        		cnt += arr[j] / mid;
        	}
        	
        	if(cnt < m)
        		right = mid - 1;
        	else 
        		left = mid + 1;
        }
        
        System.out.print(left - 1);
    }
    
}
