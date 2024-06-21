import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        String str = br.readLine();	
	
        int cnt = 0;
        boolean flag = false;
        int insertat = 0;
        for(String s : str.split(":", -1)) {
        	int slen = s.length();
       
        	if(!flag && slen == 0) {
        		insertat = cnt;
        		flag = true;
        	}
        	
        	if(slen != 0) {
        		++cnt;
        		for(int i = slen; i < 4; i++) {
            		sb.append('0');
        		}
            	sb.append(s).append(':');
        	}
        }
        
    	StringBuilder tmp = new StringBuilder();
    	for(int i = 0; i < 8 - cnt; i++) {
    		tmp.append("0000:");
		}
        if(flag) {
        	sb.insert(insertat * 5, tmp);
        }

		System.out.println(sb.deleteCharAt(39));

    }
    
}
