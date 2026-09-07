/**
 * 940. Distinct Subsequences II
 * Time: O(n)
 * Space: O(26)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        // ending[c] = distinct subsequences ending in character c
        long[] ending = new long[26];
        long total = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            // append c to every existing subsequence, plus "c" alone
            long updated = (total + 1) % MOD;
            // overwrite the bucket: earlier duplicates are regenerated here
            total = (total - ending[c] + updated + MOD) % MOD;
            ending[c] = updated;
        }

        return (int) (total % MOD);
    }
}
