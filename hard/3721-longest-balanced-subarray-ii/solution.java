import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 3721. Longest Balanced Subarray II
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int longestBalancedSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Deque<Integer>> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums[i], k -> new ArrayDeque<>()).add(i);
        }

        SegmentTree st = new SegmentTree(n);

        for (Map.Entry<Integer, Deque<Integer>> e : pos.entrySet()) {
            int v = e.getKey();
            int sign = (v % 2 == 1) ? 1 : -1;
            st.rangeAdd(e.getValue().peekFirst(), n - 1, sign);
        }

        int ans = 0;

        for (int l = 0; l < n; l++) {
            int r = st.findZero(l);
            if (r != -1) {
                ans = Math.max(ans, r - l + 1);
            }

            int v = nums[l];
            int sign = (v % 2 == 1) ? 1 : -1;
            Deque<Integer> dq = pos.get(v);
            dq.pollFirst();
            int nxt = dq.isEmpty() ? n : dq.peekFirst();
            st.rangeAdd(l, nxt - 1, -sign);
        }

        return ans;
    }
}

class SegmentTree {
    int n;
    int[] minv, maxv, lazy;

    SegmentTree(int n) {
        this.n = n;
        minv = new int[4 * n];
        maxv = new int[4 * n];
        lazy = new int[4 * n];
    }

    void push(int idx) {
        if (lazy[idx] != 0) {
            for (int child : new int[]{idx * 2, idx * 2 + 1}) {
                minv[child] += lazy[idx];
                maxv[child] += lazy[idx];
                lazy[child] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    void pull(int idx) {
        minv[idx] = Math.min(minv[idx * 2], minv[idx * 2 + 1]);
        maxv[idx] = Math.max(maxv[idx * 2], maxv[idx * 2 + 1]);
    }

    void rangeAdd(int l, int r, int val) {
        rangeAdd(l, r, val, 1, 0, n - 1);
    }

    void rangeAdd(int l, int r, int val, int idx, int nl, int nr) {
        if (r < nl || nr < l) return;
        if (l <= nl && nr <= r) {
            minv[idx] += val;
            maxv[idx] += val;
            lazy[idx] += val;
            return;
        }
        push(idx);
        int mid = (nl + nr) / 2;
        rangeAdd(l, r, val, idx * 2, nl, mid);
        rangeAdd(l, r, val, idx * 2 + 1, mid + 1, nr);
        pull(idx);
    }

    int findZero(int ql) {
        return findZero(ql, 1, 0, n - 1);
    }

    int findZero(int ql, int idx, int nl, int nr) {
        if (nr < ql || minv[idx] > 0 || maxv[idx] < 0) return -1;
        if (nl == nr) return nl;
        push(idx);
        int mid = (nl + nr) / 2;
        int right = findZero(ql, idx * 2 + 1, mid + 1, nr);
        if (right != -1) return right;
        return findZero(ql, idx * 2, nl, mid);
    }
}
