/**
 * 188. Best Time to Buy and Sell Stock IV
 * Time: O(n * k), or O(n) when k allows unlimited transactions
 * Space: O(k)
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2 || k == 0) {
            return 0;
        }

        // a transaction needs 2 days, so k >= n / 2 means the cap never
        // binds: just take every rise
        if (k >= n / 2) {
            int total = 0;
            for (int i = 1; i < n; i++) {
                total += Math.max(0, prices[i] - prices[i - 1]);
            }
            return total;
        }

        int[] buy = new int[k + 1];   // cash while holding the j-th share
        int[] sell = new int[k + 1];  // cash after closing the j-th transaction
        java.util.Arrays.fill(buy, Integer.MIN_VALUE / 2);
        buy[0] = Integer.MIN_VALUE / 2;

        for (int p : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - p);
                sell[j] = Math.max(sell[j], buy[j] + p);
            }
        }

        return sell[k];
    }
}
