/**
 * 1569. Number of Ways to Reorder Array to Get Same BST
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] fact;
    private long[] invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // nums is a permutation of 1..n, so pos is total
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[nums[i]] = i;
        }

        buildFactorials(n);

        // The BST built by inserting a permutation is the treap on
        // (value, insertion index): a BST by value, a min-heap by index.
        // Walking values ascending walks the tree in order, so build it with
        // the right-spine stack sweep. 0 stands for a missing child.
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int[] stack = new int[n + 1];
        int sp = 0;
        for (int v = 1; v <= n; v++) {
            int last = 0;
            while (sp > 0 && pos[stack[sp - 1]] > pos[v]) {
                last = stack[--sp];  // younger than v, so it sinks below v
            }
            left[v] = last;
            if (sp > 0) {
                right[stack[sp - 1]] = v;
            }
            stack[sp++] = v;
        }
        int root = stack[0];

        // Every subtree spans a contiguous value interval, so sizes come from
        // a top-down sweep without needing a post-order traversal.
        int[] lo = new int[n + 1];
        int[] hi = new int[n + 1];
        int[] size = new int[n + 1];
        lo[root] = 1;
        hi[root] = n;
        sp = 0;
        stack[sp++] = root;
        while (sp > 0) {
            int v = stack[--sp];
            size[v] = hi[v] - lo[v] + 1;
            if (left[v] != 0) {
                lo[left[v]] = lo[v];
                hi[left[v]] = v - 1;
                stack[sp++] = left[v];
            }
            if (right[v] != 0) {
                lo[right[v]] = v + 1;
                hi[right[v]] = hi[v];
                stack[sp++] = right[v];
            }
        }

        // ways = product of C(L + R, L) over nodes, with L + R = size[v] - 1
        long ways = 1;
        for (int v = 1; v <= n; v++) {
            ways = ways * comb(size[v] - 1, size[left[v]]) % MOD;
        }

        return (int) ((ways - 1 + MOD) % MOD);
    }

    private void buildFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
    }

    private long comb(int a, int b) {
        return fact[a] * invFact[b] % MOD * invFact[a - b] % MOD;
    }

    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
