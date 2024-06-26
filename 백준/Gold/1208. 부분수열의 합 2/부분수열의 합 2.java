import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int[] arr;
    
    public static void subseq(int start, int end, long currentSum, List<Long> sums) {
        if (start > end) {
            sums.add(currentSum);
            return;
        }
        subseq(start + 1, end, currentSum, sums);
        subseq(start + 1, end, currentSum + arr[start], sums);
    }

    public static long meetInTheMiddle(int n, long target) {
        List<Long> lsums = new ArrayList<>();
        subseq(0, n / 2 - 1, 0, lsums);
        
        List<Long> rsums = new ArrayList<>();
        subseq(n / 2, n - 1, 0, rsums);

        Collections.sort(rsums);
        
        long cnt = 0;

        for (long sum : lsums) {
            long complement = target - sum;
            cnt += countOccurrences(rsums, complement);
        }
        
        if (target == 0) {
            return cnt - 1; // Subtract one to exclude the empty subsequence
        } else {
            return cnt;
        }
    }
    
    public static long countOccurrences(List<Long> sortedList, long value) {
        int leftIndex = lowerBound(sortedList, value);
        int rightIndex = upperBound(sortedList, value);
        return rightIndex - leftIndex;
    }
    
    public static int lowerBound(List<Long> sortedList, long value) {
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
    
    public static int upperBound(List<Long> sortedList, long value) {
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
        long s = Long.parseLong(st.nextToken());
        StringTokenizer nst = new StringTokenizer(br.readLine());

        int ni = 0;
        arr = new int[n];
        while (nst.hasMoreTokens()) {  
            arr[ni++] = Integer.parseInt(nst.nextToken());
        }

        System.out.println(meetInTheMiddle(n, s));
    }
}
