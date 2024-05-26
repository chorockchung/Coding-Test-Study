import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rslt = 0;
		int j = 0;
		String str = br.readLine();
		Set<String> set = new HashSet<>();
		for(int i = 1; i < str.length(); i++) {
			while(j+i <= str.length()) {
				set.add(str.substring(j, j+i));	
				j++;
			}
			j = 0;
		}

		System.out.print(set.size() + 1);
	}
}