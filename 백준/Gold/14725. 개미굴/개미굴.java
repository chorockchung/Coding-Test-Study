import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		Map<String, Node> child = new HashMap<>();
	}
	
	static class Trie {
		final Node root;
		
		Trie() {
			root = new Node();
		}
			
		void insert(String[] strs, int k) {
			Node current = root;
			for(int i = 0; i < k; i++) {
				current = current.child.computeIfAbsent(strs[i], key -> new Node());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String dash = "--";
        
		void searchAndPrint(Node root, int floor) {
			Node current = root;
			List<String> list;
        
            if(current.child.keySet() != null) {
				list = new ArrayList<>(current.child.keySet());
				Collections.sort(list);
				
				for(String s : list) {
					sb.append(dash.repeat(floor));
					sb.append(s  + "\n");
					searchAndPrint(current.child.get(s), floor+1); //재귀
				}
			}
            
			System.out.print(sb);
			sb.delete(0, sb.length());
		}
	}
    
	public static void main(String[] args) throws IOException {
		Trie t = new Trie();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			String[] strs = new String[k];
			for(int x = 0; x < k; x++)
				strs[x] = st.nextToken();
			t.insert(strs, k);
		}
		
		t.searchAndPrint(t.root, 0);		
	}
}
