/**
 * 3871. Count Commas in Range II
 * Time: O(log n)
 * Space: O(1)
 */
class Solution {
    public long countCommas(long n) {
        long total = 0;
        long threshold = 1000;
        // every number >= threshold has earned one more comma
        while (threshold <= n) {
            total += n - threshold + 1;
            threshold *= 1000;
        }
        return total;
    }
}
