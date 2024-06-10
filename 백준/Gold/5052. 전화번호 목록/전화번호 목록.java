import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	Node[] child;
	boolean eow;
	
	Node() {
		child = new Node[10]; //0-9까지
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
			
			if(current.child[chIdx].eow) //앞서 입력된 문자열이 접두사인 경우
				return false;
			if(i == str.length() - 1) {
				current.child[chIdx].eow = true;
				if(!flag) //마지막인데 새로운 노드를 추가하지 못했다면 해당 문자열은 앞서 입력된 문자열의 접두사(더 짧다) 
					return false; 
			}
			else
				current = current.child[chIdx];
		}
		return true; //계속해서 추가됐다면 새로운 문자 
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
