import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    static int arr[];
    
    public static void swap(int a, int b) {
    	int tmp = arr[b];
    	arr[b] = arr[a];
    	arr[a] = tmp;
    }
    
    public static int get_median(int st, int end) {
    	int mid = st + (end - st) / 2;
    	
    	if(arr[st] > arr[mid])
    		swap(st, mid);
    	if(arr[st] > arr[end])
    		swap(st, end);
    	if(arr[mid] > arr[end])
    		swap(mid, end);

    	return arr[mid];
    }
    
    public static void quicksort(int st, int end) {
    	 if (st >= end) {
             return;  // base case: array is already sorted
         }
    	int pivot = get_median(st, end);
    	int left = st;
    	int right = end;
    	
    	while(left <= right) {
    		while(arr[left] < pivot)
    			left++;
    		while(arr[right] > pivot)
    			right--;
    		
    		if(left <= right) {
    			swap(left, right);
    			left++;
    			right--;
    		}
    	}
    	
    	quicksort(st, right);
    	quicksort(left, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[t];
        int i = 0;
        while(st.hasMoreTokens()) {
        	arr[i++] = Integer.parseInt(st.nextToken());
        }
        
        quicksort(0, t-1);
        
        int rslt = 0;
        int sum = 0;
        for(i = 0; i < t; i++) {
        	sum = 0;
        	 for(int j = 0; j <= i; j++) {
        		 sum += arr[j];       		 
        	 }
        	 rslt += sum;
        }
        	
       System.out.println(rslt);               
    }
}
