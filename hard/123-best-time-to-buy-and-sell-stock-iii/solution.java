/**
 * 123. Best Time to Buy and Sell Stock III
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        // cash while holding the 1st / 2nd share, and after selling each
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int p : prices) {
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1, buy1 + p);
            buy2 = Math.max(buy2, sell1 - p);
            sell2 = Math.max(sell2, buy2 + p);
        }

        return sell2;
    }
}
