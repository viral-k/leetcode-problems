/**
 * 3863. Minimum Operations to Sort a String
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }

        // every proper substring has length 1, so nothing can change
        if (n == 2) {
            return -1;
        }

        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        char lo = 'a';
        while (count[lo - 'a'] == 0) {
            lo++;
        }
        char hi = 'z';
        while (count[hi - 'a'] == 0) {
            hi--;
        }

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        // the minimal window to sort runs from the first to the last mismatch
        // with sorted(s); one op works iff that window is not the whole string
        if (first == lo || last == hi) {
            return 1;
        }

        // unique max stuck at index 0 and unique min stuck at index n-1: each
        // has to be relocated before it can reach its final end, and no single
        // proper window touches both ends
        if (first == hi && last == lo
                && count[hi - 'a'] == 1 && count[lo - 'a'] == 1) {
            return 3;
        }

        // sort [0, n-2] then [1, n-1] if the min appears by index n-2,
        // otherwise sort [1, n-1] then [0, n-2]
        return 2;
    }
}
