import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < m+n; i++) {
			String name = br.readLine();
			if(!set.add(name)) {
				list.add(name);
			}
		}	
		
		Collections.sort(list);	
		for(String name : list) {
			sb.append(name + '\n');
		}
		
		System.out.print(list.size() + "\n" + sb);
	}
}