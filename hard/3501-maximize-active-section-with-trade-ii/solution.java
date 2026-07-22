import java.util.ArrayList;
import java.util.List;

/**
 * 3501. Maximize Active Section with Trade II
 * Time: O(n log n + q log n)
 * Space: O(n log n)
 */
class Solution {
    private int[][] sparse;
    private int[] logTable;

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        // Maximal zero-runs of s.
        List<int[]> runs = new ArrayList<>(); // {start, end}
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int j = i;
                while (j < n && s.charAt(j) == '0') {
                    j++;
                }
                runs.add(new int[]{i, j - 1});
                i = j;
            } else {
                i++;
            }
        }

        int cnt = runs.size();
        int[] starts = new int[cnt], ends = new int[cnt], lengths = new int[cnt];
        for (int k = 0; k < cnt; k++) {
            starts[k] = runs.get(k)[0];
            ends[k] = runs.get(k)[1];
            lengths[k] = ends[k] - starts[k] + 1;
        }

        // P[i] = full adjacent-pair sum; sparse table for range max.
        int m = Math.max(0, cnt - 1);
        int[] P = new int[m];
        for (int k = 0; k < m; k++) {
            P[k] = lengths[k] + lengths[k + 1];
        }
        buildSparse(P, m);

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int a = lowerBoundEnds(ends, cnt, l);   // first run with end >= l
            int b = upperBoundStarts(starts, cnt, r) - 1; // last run with start <= r

            if (a > b || a >= cnt || b < 0 || a == b) {
                ans.add(totalOnes);
                continue;
            }

            int lenA = Math.min(ends[a], r) - Math.max(starts[a], l) + 1;
            int lenB = Math.min(ends[b], r) - Math.max(starts[b], l) + 1;

            // leading pair (a, a+1) and trailing pair (b-1, b)
            int gain = lenA + (a + 1 == b ? lenB : lengths[a + 1]);
            gain = Math.max(gain, (b - 1 == a ? lenA : lengths[b - 1]) + lenB);

            // fully-interior pairs
            if (a + 1 <= b - 2) {
                gain = Math.max(gain, rangeMax(a + 1, b - 2));
            }

            ans.add(totalOnes + gain);
        }
        return ans;
    }

    private void buildSparse(int[] P, int m) {
        logTable = new int[Math.max(2, m + 1)];
        for (int i = 2; i <= m; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }
        int levels = (m > 0) ? logTable[m] + 1 : 1;
        sparse = new int[levels][];
        sparse[0] = P;
        for (int k = 1; k < levels; k++) {
            int len = m - (1 << k) + 1;
            sparse[k] = new int[Math.max(0, len)];
            int span = 1 << (k - 1);
            for (int i = 0; i < len; i++) {
                sparse[k][i] = Math.max(sparse[k - 1][i], sparse[k - 1][i + span]);
            }
        }
    }

    private int rangeMax(int lo, int hi) {
        int k = logTable[hi - lo + 1];
        return Math.max(sparse[k][lo], sparse[k][hi - (1 << k) + 1]);
    }

    /** First index with ends[idx] >= target. */
    private int lowerBoundEnds(int[] ends, int cnt, int target) {
        int lo = 0, hi = cnt;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (ends[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /** First index with starts[idx] > target. */
    private int upperBoundStarts(int[] starts, int cnt, int target) {
        int lo = 0, hi = cnt;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (starts[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
