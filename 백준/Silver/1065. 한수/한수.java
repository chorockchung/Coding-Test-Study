import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(br.readLine());

    		int rslt = 0;
    		int quota = n / 100;
    		if(n == 1000) rslt = 144;
    		else if(quota < 10 && quota != 0) {
    			rslt += 99;
    			rslt += (quota - 1) * 5;
    			int i = 0;
    			int hap = 0;
    			while(quota - i*2 >= 0) {
    				hap = quota * 100 + (quota - i) * 10 + (quota - i*2);
    				if(hap <= n)
    					rslt++;
    				i++;
    			}
    			i = 1;
    			while(quota + i*2 < 10) {
    				hap = quota * 100 + (quota + i) * 10 + (quota + i*2);
    				if(hap <= n)
    					rslt++;
    				i++;
    			}
    		}
    		else rslt = n;
    		   		
    		System.out.println(rslt);
    }
}
