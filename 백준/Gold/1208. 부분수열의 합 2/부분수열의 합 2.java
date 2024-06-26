import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int[] arr;
    
    public static void subseq(int start, int end, int currentSum, List<Integer> sums) {
        if (start > end) {
            sums.add(currentSum);
            return;
        }
        subseq(start + 1, end, currentSum, sums);
        subseq(start + 1, end, currentSum + arr[start], sums);
    }

    public static long meetInTheMiddle(int n, int target) {
        List<Integer> lsums = new ArrayList<>();
        subseq(0, n / 2 - 1, 0, lsums);
        
        List<Integer> rsums = new ArrayList<>();
        subseq(n / 2, n - 1, 0, rsums);

        Collections.sort(rsums);
        
        long cnt = 0;

        for (int sum : lsums) {
            int complement = target - sum;
            cnt += countOccurrences(rsums, complement);
        }
        
        if (target == 0) {
            return cnt - 1; // Subtract one to exclude the empty subsequence
        } else {
            return cnt;
        }
    }
    
    public static int countOccurrences(List<Integer> sortedList, int value) {
        int leftIndex = lowerBound(sortedList, value);
        int rightIndex = upperBound(sortedList, value);
        return rightIndex - leftIndex;
    }
    
    public static int lowerBound(List<Integer> sortedList, int value) {
        int left = 0, right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public static int upperBound(List<Integer> sortedList, int value) {
        int left = 0, right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        StringTokenizer nst = new StringTokenizer(br.readLine());

        int ni = 0;
        arr = new int[n];
        while (nst.hasMoreTokens()) {  
            arr[ni++] = Integer.parseInt(nst.nextToken());
        }

        System.out.println(meetInTheMiddle(n, s));
    }
}
