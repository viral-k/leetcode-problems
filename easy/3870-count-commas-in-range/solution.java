/**
 * 3870. Count Commas in Range
 * Time: O(log n)
 * Space: O(1)
 */
class Solution {
    public int countCommas(int n) {
        long total = 0;
        long threshold = 1000;
        // every number >= threshold has earned one more comma
        while (threshold <= n) {
            total += n - threshold + 1;
            threshold *= 1000;
        }
        return (int) total;
    }
}
