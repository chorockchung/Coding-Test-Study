import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static class Node {
		Map<Character, Node> childNode = new HashMap<>();
		boolean endOfWord = false;
		int count = 0;
	}
	
	static class Trie {
		final Node root;
		
		Trie() {
			root = new Node();
		}
		
		String insert(String str) {
			Node current = root;
			StringBuilder prefix = new StringBuilder();
			boolean flag = false;
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(!flag && !current.childNode.containsKey(ch)) {
					prefix.append(ch);
					flag = true;
				}
				current = current.childNode.computeIfAbsent(ch, key -> new Node());		
				
				if(!flag)
					prefix.append(ch);			
					
				if(i == str.length() - 1) {
					++current.count;
					if(current.endOfWord && !flag) {
						return "C" + String.valueOf(current.count); //nickname 이라는 뜻
					}	
					current.endOfWord = true;
				}
			}	
			return prefix.toString();
		}

	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder rslt = new StringBuilder();
		
		Trie t = new Trie();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			sb.append(br.readLine());
			String prefix = t.insert(sb.toString());				
			if(prefix.charAt(0) == 'C')
				rslt.append(sb).append(prefix.substring(1)).append('\n');
			else
				rslt.append(prefix).append('\n');
			
			sb.delete(0, sb.length());
		}
	
		System.out.print(rslt);
	}
}
