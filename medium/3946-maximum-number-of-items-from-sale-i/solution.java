/**
 * 3946. Maximum Number of Items From Sale I
 * Time: O(n * budget + F log F), F = max factor
 * Space: O(budget + F)
 */
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxF = 0, pMin = Integer.MAX_VALUE;
        for (int[] it : items) {
            maxF = Math.max(maxF, it[0]);
            pMin = Math.min(pMin, it[1]);
        }
        int[] cnt = new int[maxF + 1];
        for (int[] it : items) cnt[it[0]]++;

        // The first copy of item i is worth 1 + (other items whose factor is a multiple of factor_i).
        int[] multiples = new int[maxF + 1];
        for (int f = 1; f <= maxF; f++) {
            if (cnt[f] == 0) continue;
            for (int m = f; m <= maxF; m += f) multiples[f] += cnt[m];
        }

        // 0/1 knapsack over first copies: dp[c] = best value with total price <= c.
        int[] dp = new int[budget + 1];
        for (int[] it : items) {
            int p = it[1];
            if (p > budget) continue;
            int v = multiples[it[0]]; // 1 (itself) + others = multiples count
            for (int c = budget; c >= p; c--) {
                dp[c] = Math.max(dp[c], dp[c - p] + v);
            }
        }

        // Extra copies are worth 1 each, so spend the leftover on the cheapest item.
        int best = 0;
        for (int c = 0; c <= budget; c++) {
            best = Math.max(best, dp[c] + (budget - c) / pMin);
        }
        return best;
    }
}
