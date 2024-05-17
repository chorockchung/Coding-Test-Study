import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static boolean func(String str) {
		boolean flag = true;
		
		List<Character> alphabets = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (alphabets.contains(tmp) && alphabets.get(alphabets.size()-1) != tmp) {
				flag = false;
				break;
			}
			else alphabets.add(str.charAt(i));
		}
		
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rslt = 0;
		String s = br.readLine();
		int n = Integer.parseInt(s);

		for(int i = 0; i < n; i++) {
			if(func(br.readLine()) == true)
				rslt += 1;
		}
		
		System.out.print(rslt);
	}
}