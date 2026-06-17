/**
 * 3614. Process String with Special Operations II
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String processStr(String s, long k) {
        final long CAP = 2_000_000_000_000_000L; // above max k and max length

        int n = s.length();
        long[] lengths = new long[n];
        long cur = 0;

        // Forward pass: length of the buffer after each step.
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (cur > 0) {
                    cur -= 1;
                }
            } else if (ch == '#') {
                cur = Math.min(cur * 2, CAP);
            } else if (ch == '%') {
                // length unchanged
            } else {
                cur = Math.min(cur + 1, CAP);
            }
            lengths[i] = cur;
        }

        if (k >= cur) {
            return ".";
        }

        // Backward pass: trace k to the letter that produced it.
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long before = i > 0 ? lengths[i - 1] : 0;

            if (ch == '*') {
                continue;
            } else if (ch == '#') {
                if (k >= before) {
                    k -= before;
                }
            } else if (ch == '%') {
                k = before - 1 - k;
            } else {
                if (k == before) {
                    return String.valueOf(ch);
                }
            }
        }

        return ".";
    }
}
