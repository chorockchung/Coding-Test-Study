class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        int max = 0;
        for (int t : times) {
            if (t > max)
                max = t;
        }

        long left = 0;
        long right = (long) n * max; // Casting to long to avoid overflow

        while (left < right) {
            long mid = (left + right) / 2; // mid is time

            long cnt = 0; // Using long to avoid potential overflow
            for (int t : times) {
                cnt += mid / t;
            }

            if (cnt < n) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return right;
    }
}
