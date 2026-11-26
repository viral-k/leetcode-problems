import java.util.*;

/**
 * 282. Expression Add Operators
 * Time: O(n * 4^n)
 * Space: O(n) besides the output
 */
class Solution {
    private String num;
    private long target;
    private char[] buf;
    private List<String> out;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        this.buf = new char[2 * num.length()]; // digits plus operators
        this.out = new ArrayList<>();
        dfs(0, 0, 0, 0);
        return out;
    }

    // value: the expression so far. last: its final term with sign, so a '*'
    // can take it back out and put back last * x. A 10-digit operand needs long.
    private void dfs(int i, int len, long value, long last) {
        int n = num.length();
        if (i == n) {
            if (value == target) {
                out.add(new String(buf, 0, len));
            }
            return;
        }
        long x = 0;
        for (int j = i; j < n; j++) {
            if (j > i && num.charAt(i) == '0') {
                break; // no operands with leading zeros
            }
            x = x * 10 + (num.charAt(j) - '0');
            int digits = j - i + 1;
            if (i == 0) {
                num.getChars(i, j + 1, buf, 0);
                dfs(j + 1, digits, x, x);
            } else {
                num.getChars(i, j + 1, buf, len + 1);
                buf[len] = '+';
                dfs(j + 1, len + 1 + digits, value + x, x);
                buf[len] = '-';
                dfs(j + 1, len + 1 + digits, value - x, -x);
                buf[len] = '*';
                dfs(j + 1, len + 1 + digits, value - last + last * x, last * x);
            }
        }
    }
}
