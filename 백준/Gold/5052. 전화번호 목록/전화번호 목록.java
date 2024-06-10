import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	Node[] child;
	boolean eow;
	
	Node() {
		child = new Node[10];
		eow = false;
	}
}

class Trie {
	Node root;
	
	Trie() {
		root = new Node();
	}
	
	boolean insert(String str) {		
		Node current = this.root;
		int chIdx = ' ';
		boolean flag = false;
		for(int i = 0; i < str.length(); i++) {
			chIdx = str.charAt(i) - '0';
			
			if(current.child[chIdx] == null) {
				current.child[chIdx] = new Node();
				flag = true;
			}		
			
			if(current.child[chIdx].eow) 
				return false;
			if(i == str.length() - 1) {
				current.child[chIdx].eow = true;
				if(!flag)
					return false;
			}
			else
				current = current.child[chIdx];
		}
		return true;
	}	
}

public class Main {	
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
						
		int caseNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < caseNum; i++) {
			Trie trie = new Trie();
			int n = Integer.parseInt(br.readLine());
			boolean rslt = true;
			for(int j = 0; j < n; j++) {
				String str = br.readLine();
				if(rslt)
					rslt = trie.insert(str);
			}
			if(!rslt) 
				sb.append("NO");
			else 
				sb.append("YES");
			sb.append('\n');
		}
        
		System.out.println(sb);
	}
    
}
