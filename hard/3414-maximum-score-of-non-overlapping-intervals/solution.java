import java.util.Arrays;

/**
 * 3414. Maximum Score of Non-overlapping Intervals
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int[] maximumWeight(java.util.List<java.util.List<Integer>> intervals) {
        int n = intervals.size();
        int[] left = new int[n], right = new int[n];
        long[] weight = new long[n];
        for (int i = 0; i < n; i++) {
            left[i] = intervals.get(i).get(0);
            right[i] = intervals.get(i).get(1);
            weight[i] = intervals.get(i).get(2);
        }

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(left[a], left[b]));

        int[] sortedLefts = new int[n];
        for (int p = 0; p < n; p++) {
            sortedLefts[p] = left[order[p]];
        }

        // nxt[p] = first sorted position whose left endpoint is strictly past r_p;
        // strict because intervals sharing a boundary still overlap
        int[] nxt = new int[n];
        for (int p = 0; p < n; p++) {
            nxt[p] = upperBound(sortedLefts, right[order[p]]);
        }

        // score[p][k] and idx[p][k] = best score and its sorted original indices
        long[][] score = new long[n + 1][5];
        int[][][] idx = new int[n + 1][5][];
        for (int k = 0; k < 5; k++) {
            idx[n][k] = new int[0];
        }

        for (int p = n - 1; p >= 0; p--) {
            idx[p][0] = new int[0];
            for (int k = 1; k <= 4; k++) {
                long bestScore = score[p + 1][k];          // skip this interval
                int[] bestIdx = idx[p + 1][k];

                long candScore = score[nxt[p]][k - 1] + weight[order[p]];
                int[] candIdx = insertSorted(idx[nxt[p]][k - 1], order[p]);

                // higher score wins; ties go to the lexicographically smaller indices
                if (candScore > bestScore
                        || (candScore == bestScore && lexLess(candIdx, bestIdx))) {
                    bestScore = candScore;
                    bestIdx = candIdx;
                }
                score[p][k] = bestScore;
                idx[p][k] = bestIdx;
            }
        }

        return idx[0][4];
    }

    /** First position in a sorted array holding a value strictly greater than target. */
    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int[] insertSorted(int[] base, int value) {
        int[] out = new int[base.length + 1];
        int i = 0;
        while (i < base.length && base[i] < value) {
            out[i] = base[i];
            i++;
        }
        out[i] = value;
        while (i < base.length) {
            out[i + 1] = base[i];
            i++;
        }
        return out;
    }

    private boolean lexLess(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return a.length < b.length;
    }
}
