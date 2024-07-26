import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
    static PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
    
    public static List<Integer> func(int m, BufferedReader br) throws NumberFormatException, IOException {
        
    	List<Integer> al = new ArrayList<>();
        StringTokenizer st = null;

        for (int i = 0; i < m; i++) {
        	if(i % 10 == 0 ) {
        		st = new StringTokenizer(br.readLine());
        	}
            int num = Integer.parseInt(st.nextToken());

            if (pqMax.size() == pqMin.size()) {
                pqMax.add(num);
            } else {
                pqMin.add(num);
            }
            if (!pqMin.isEmpty() && pqMax.peek() > pqMin.peek()) {
                pqMin.add(pqMax.poll());
                pqMax.add(pqMin.poll());
            }

            if (i % 2 == 0) {
                al.add(pqMax.peek());
            }
        }
        
        return al;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
        	int m = Integer.parseInt(br.readLine());
        	List<Integer> al = func(m, br);
        	int cnt = 0;
            sb.append(al.size()).append('\n');
            
        	for(int a : al) {
        		++cnt;
        		sb.append(a).append(" ");
        		if(cnt != 0 && cnt % 10 == 0)
        			sb.append('\n');
        	}
        	sb.append('\n');

        	pqMax.clear();
        	pqMin.clear();
        }
        	
       System.out.println(sb);               
    }
}
