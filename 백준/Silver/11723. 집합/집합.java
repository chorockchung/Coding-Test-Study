import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int s = 0;
        int i = 0;
        while(i < n) {
        	st = new StringTokenizer(br.readLine());
        	String oper = st.nextToken();
        	int x = 0;
        	if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

        	switch(oper) {
	        	case "add": s |= (1<<x); break;
	        	case "check":        
	        		sb.append((s & (1<<x)) != 0 ? 1 : 0).append('\n');
	        		break;
	        	case "remove": s &= ~(1<<x); break;
	        	case "toggle": s ^= (1<<x); break;
	        	case "all" : s = (1<<21) - 1; break;
	        	case "empty" : s = 0; break;
        	}
        	i++;
        }
        
        System.out.println(sb);
    }
}

