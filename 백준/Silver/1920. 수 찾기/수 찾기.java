import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
	
        int[] arr = new int[n];
        int ni = 0;
        while(st1.hasMoreTokens()) {
        	arr[ni++] = Integer.parseInt(st1.nextToken());
        }
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(st2.hasMoreTokens()) {
        	boolean flag = false;
    		int t = Integer.parseInt(st2.nextToken());
    		int left = 0;
    	    int right = n - 1;
    	    int mid;
        	while(left <= right) {
        		mid = (left + right) / 2;
        		if(t < arr[mid])
        			right = mid - 1;
        		else if(t > arr[mid])
        			left = mid + 1;
        		else {
        			flag = true;
        			break;
        		}
        	}
    		sb.append(flag ? 1 : 0).append('\n');
        }
        
        System.out.print(sb);

    }
    
}
