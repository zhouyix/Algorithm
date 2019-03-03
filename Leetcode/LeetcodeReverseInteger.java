public class Solution {
    public int reverse(int x) {
     int sum = 0;
        boolean positive = (x >= 0);

        while (x != 0) {
            int dig = x % 10;
            if (positive && sum > Integer.MAX_VALUE/10)
                return 0;
            if (!positive && sum < Integer.MIN_VALUE/10)
                return 0;
            sum = (sum * 10) + dig;
            x /=10;
        }
        return sum;  

    }
}