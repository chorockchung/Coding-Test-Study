import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());	
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int i = 0;
        while(st2.hasMoreTokens()) {
        	nums[i++] = Integer.parseInt(st2.nextToken());    			
        }
        
        Arrays.sort(nums);
        
        int j = 0, k=0;
        int max = 0;
        for(i = n -1; i >= 2; i--) {
        	for(j = i - 1; j >= 1; j--) {
        		for(k = j -1; k >=0; k--) {
        			if(nums[i] + nums[j] + nums[k] <= m && nums[i] + nums[j] + nums[k] > max) {
        				max = nums[i] + nums[j] + nums[k];
        			}
        			else
        				continue;
        		}
        	}
        }

		System.out.println(max);

    }
    
}
