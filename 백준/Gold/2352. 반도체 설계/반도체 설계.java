import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int bs(int right, int[] arr, int key) {
    	int left = 0;
    	while(left <= right) {
    		int mid = (left+right)/2;
    		
    		if(arr[mid] < key)
    			left = mid + 1;
    		else
    			right = mid - 1;   			
    	}
    	arr[left] = key;
    	return left;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        arr[0] = Integer.parseInt(st.nextToken());
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
           int idx = bs(maxIdx, arr, Integer.parseInt(st.nextToken()));
           maxIdx = Math.max(idx, maxIdx);
        }
        
        System.out.println(maxIdx+1);
    }    
}
