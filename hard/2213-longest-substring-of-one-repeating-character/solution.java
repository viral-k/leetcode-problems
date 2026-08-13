/**
 * 2213. Longest Substring of One Repeating Character
 * Time: O((n + k) log n)
 * Space: O(n)
 */
class Solution {
    // Per-node: prefix run, suffix run, best run, edge chars, segment length.
    private int[] pre, suf, best, lc, rc, ln;
    private int size;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        size = 1;
        while (size < n) {
            size <<= 1;
        }

        pre = new int[2 * size];
        suf = new int[2 * size];
        best = new int[2 * size];
        lc = new int[2 * size];
        rc = new int[2 * size];
        ln = new int[2 * size];

        for (int i = 0; i < n; i++) {
            int j = size + i;
            pre[j] = suf[j] = best[j] = ln[j] = 1;
            lc[j] = rc[j] = s.charAt(i);
        }
        for (int i = size - 1; i >= 1; i--) {
            pull(i);
        }

        int k = queryIndices.length;
        int[] result = new int[k];
        for (int q = 0; q < k; q++) {
            int j = size + queryIndices[q];
            lc[j] = rc[j] = queryCharacters.charAt(q);
            j >>= 1;
            while (j >= 1) {
                pull(j);
                j >>= 1;
            }
            result[q] = best[1];
        }
        return result;
    }

    private void pull(int i) {
        int l = 2 * i, r = 2 * i + 1;
        if (ln[l] == 0) { // padding child acts as identity
            pre[i] = pre[r]; suf[i] = suf[r]; best[i] = best[r];
            lc[i] = lc[r]; rc[i] = rc[r]; ln[i] = ln[r];
            return;
        }
        if (ln[r] == 0) {
            pre[i] = pre[l]; suf[i] = suf[l]; best[i] = best[l];
            lc[i] = lc[l]; rc[i] = rc[l]; ln[i] = ln[l];
            return;
        }
        ln[i] = ln[l] + ln[r];
        lc[i] = lc[l];
        rc[i] = rc[r];
        boolean join = rc[l] == lc[r];
        int b = Math.max(best[l], best[r]);
        if (join) {
            b = Math.max(b, suf[l] + pre[r]); // run crossing the boundary
        }
        best[i] = b;
        // a child that is entirely one character lets the run continue
        pre[i] = pre[l] + ((join && pre[l] == ln[l]) ? pre[r] : 0);
        suf[i] = suf[r] + ((join && suf[r] == ln[r]) ? suf[l] : 0);
    }
}
