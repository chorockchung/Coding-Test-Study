import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int nowVote = Integer.parseInt(br.readLine());
        int rslt = 0;
        
        for(int i = 1; i < n; i++) {
        	pQ.offer(Integer.parseInt(br.readLine()));
        }
        
        while(!pQ.isEmpty() && pQ.peek() >= nowVote) {
        	int e = pQ.poll();
        	++nowVote;
        	--e;
        	++rslt;
        	pQ.offer(e);
        }
        
        System.out.println(rslt);
    }
}
