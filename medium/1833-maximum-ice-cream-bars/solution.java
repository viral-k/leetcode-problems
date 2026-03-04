/**
 * 1833. Maximum Ice Cream Bars
 * Time: O(n + m)
 * Space: O(m)
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int c : costs) {
            maxCost = Math.max(maxCost, c);
        }

        int[] freq = new int[maxCost + 1];
        for (int c : costs) {
            freq[c]++;
        }

        int count = 0;

        for (int cost = 1; cost <= maxCost; cost++) {
            if (freq[cost] == 0) continue;

            long totalCost = (long) cost * freq[cost];

            if (coins >= totalCost) {
                coins -= totalCost;
                count += freq[cost];
            } else {
                count += coins / cost;
                break;
            }
        }

        return count;
    }
}
