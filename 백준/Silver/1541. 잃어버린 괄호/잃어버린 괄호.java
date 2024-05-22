import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<String> numList = new ArrayList<>();
		List<Character> pmList = new ArrayList<>();

		//기호, 숫자 분리
		StringBuilder sb = new StringBuilder();
		String tmp ="";
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if((ch == '+' || ch == '-')) {
				tmp = sb.toString(); // +/-를 만나면 리스트에 추가
				numList.add(tmp);
				sb = new StringBuilder();
				
				pmList.add(ch);
			}
			else {
				sb.append(ch);
			}
		}
		numList.add(sb.toString()); //마지막 값 담기
	
		if(!str.startsWith("-")) //첫번째값이 양수일 경우 +임의적으로 넣기
			pmList.add(0, '+');
		
		int idx = 0;
		int rslt = 0;
		for(int i = 0; i < pmList.size(); i++) {
			if(i + 1 < pmList.size() && pmList.get(i) == '-' && pmList.get(i+1) == '+') { //indexbound error check
				idx = i + 1;
				while(idx < pmList.size() && pmList.get(idx) == '+') { //indexbound error check
					idx++;
				}
				int hap = 0;
				for(int j = i; j < idx; j++) {
					hap += Integer.parseInt(numList.get(j));
				}
				rslt -= hap;
                i = idx - 1;
			}
			else {
				if(pmList.get(i) == '+')
					rslt += Integer.parseInt(numList.get(i));
				else
					rslt -= Integer.parseInt(numList.get(i));
			}
		}
		
		System.out.println(rslt);
	}
}