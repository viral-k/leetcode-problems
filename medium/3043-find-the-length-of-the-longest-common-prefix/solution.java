import java.util.HashSet;
import java.util.Set;

/**
 * 3043. Find the Length of the Longest Common Prefix
 * Time: O((n + m) * D), where D is the maximum digit count
 * Space: O(n * D)
 */
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        for (int num : arr1) {
            int prefix = num;
            while (prefix > 0) {
                prefixes.add(prefix);
                prefix /= 10;
            }
        }

        int longest = 0;
        for (int num : arr2) {
            int prefix = num;
            while (prefix > 0) {
                if (prefixes.contains(prefix)) {
                    longest = Math.max(longest, digitLength(prefix));
                    break;
                }
                prefix /= 10;
            }
        }

        return longest;
    }

    private int digitLength(int num) {
        int length = 0;
        while (num > 0) {
            length++;
            num /= 10;
        }
        return length;
    }
}
