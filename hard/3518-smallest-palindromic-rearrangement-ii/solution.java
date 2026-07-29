/**
 * 3518. Smallest Palindromic Rearrangement II
 * Time: O(L * 26)  (capped permutation counts short-circuit)
 * Space: O(26 + n)
 */
class Solution {
    private static final long CAP = 1_000_001L; // strictly greater than the maximum possible k

    public String smallestPalindrome(String s, int k) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        char middle = 0;
        for (int c = 0; c < 26; c++) {
            if (counts[c] % 2 == 1) {
                middle = (char) ('a' + c);
            }
            counts[c] /= 2;
        }

        // Feasibility: not enough distinct palindromes.
        if (permsCapped(counts) < k) {
            return "";
        }

        int halfLen = 0;
        for (int c : counts) {
            halfLen += c;
        }

        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < halfLen; pos++) {
            for (int ci = 0; ci < 26; ci++) {
                if (counts[ci] == 0) {
                    continue;
                }
                counts[ci]--;
                long w = permsCapped(counts);
                if (k <= w) {
                    left.append((char) ('a' + ci));
                    break;
                }
                k -= (int) w;
                counts[ci]++;
            }
        }

        String leftHalf = left.toString();
        String rightHalf = left.reverse().toString();
        return middle == 0 ? leftHalf + rightHalf : leftHalf + middle + rightHalf;
    }

    /** Distinct permutations of the multiset `counts`, capped at CAP. */
    private long permsCapped(int[] counts) {
        long result = 1;
        int n = 0;
        for (int c : counts) {
            n += c;
        }
        for (int c : counts) {
            if (c == 0) {
                continue;
            }
            result *= combCapped(n, c);
            if (result >= CAP) {
                return CAP;
            }
            n -= c;
        }
        return result;
    }

    /** C(n, r) capped at CAP, with early exit. */
    private long combCapped(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        r = Math.min(r, n - r);
        long c = 1;
        for (int i = 1; i <= r; i++) {
            c = c * (n - r + i) / i;
            if (c >= CAP) {
                return CAP;
            }
        }
        return c;
    }
}
