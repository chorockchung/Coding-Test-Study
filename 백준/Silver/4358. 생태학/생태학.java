import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new HashMap<>();
		String tree;
		int species = 0;
		while((tree = br.readLine()) != null) {
			map.put(tree, map.getOrDefault(tree, 0)+1);
			species++;
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(String s: list) {
			sb.append(s + " ");
            sb.append(String.format("%.4f\n", (map.get(s) * 100.0 / species)));
		}
		System.out.print(sb);
	    }
}