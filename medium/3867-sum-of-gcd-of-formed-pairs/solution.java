import java.util.Arrays;

/**
 * 3867. Sum of GCD of Formed Pairs
 * Time: O(n log n + n log V)
 * Space: O(n)
 */
class Solution {
    public long sumOfGcdPairs(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]); // running maximum
            prefixGcd[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefixGcd);

        // Pair smallest with largest, walking inward.
        long total = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            total += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }
        return total;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
