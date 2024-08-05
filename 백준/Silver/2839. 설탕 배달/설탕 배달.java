import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
             
        int quota = n / 5;
        int rslt = 0;
        while(quota > 0) {
        	if((n - quota * 5) % 3 != 0)
        		quota--;
        	else {	
        		rslt = quota + ((n - quota * 5) / 3);
        		break;
        	}
        }
        
        if(quota == 0) {
        	if(n % 3 != 0)
        		System.out.println("-1");
        	else
        		System.out.println(n / 3);
        }
        else
    		System.out.println(rslt);             
    }
}
