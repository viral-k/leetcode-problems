/**
 * 3734. Lexicographically Smallest Palindromic Permutation Greater Than Target
 * Time: O(26 * n)
 * Space: O(n)
 */
class Solution {
    private String mid = "";

    public String smallestPalindrome(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // A palindrome needs at most one odd-count letter, matching n's parity.
        int oddCount = 0, oddIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                oddCount++;
                oddIdx = i;
            }
        }
        if (oddCount > 1) {
            return "";
        }
        if ((n % 2 == 0) != (oddCount == 0)) {
            return "";
        }
        mid = (oddCount == 1) ? String.valueOf((char) ('a' + oddIdx)) : "";

        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }
        int h = n / 2;
        String tpre = target.substring(0, h);

        // Case 1: the left half ties with target's prefix -> a single candidate.
        int[] need = new int[26];
        for (int i = 0; i < h; i++) {
            need[tpre.charAt(i) - 'a']++;
        }
        boolean spellable = true;
        for (int i = 0; i < 26; i++) {
            if (need[i] > half[i]) {
                spellable = false;
                break;
            }
        }
        if (spellable) {
            String candidate = build(tpre);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // Case 2: smallest permutation of the half-multiset strictly above tpre.
        int[] counts = half.clone();
        int matched = 0;
        while (matched < h && counts[tpre.charAt(matched) - 'a'] > 0) {
            counts[tpre.charAt(matched) - 'a']--;
            matched++;
        }

        // A longer shared prefix gives a smaller left half, so search downward.
        for (int p = matched; p >= 0; p--) {
            while (matched > p) {
                matched--;
                counts[tpre.charAt(matched) - 'a']++;
            }
            if (p >= h) {
                continue;
            }
            for (int c = tpre.charAt(p) - 'a' + 1; c < 26; c++) {
                if (counts[c] > 0) {
                    counts[c]--;
                    StringBuilder left = new StringBuilder();
                    left.append(tpre, 0, p);
                    left.append((char) ('a' + c));
                    for (int j = 0; j < 26; j++) {
                        for (int t = 0; t < counts[j]; t++) {
                            left.append((char) ('a' + j));
                        }
                    }
                    return build(left.toString());
                }
            }
        }

        return "";
    }

    private String build(String left) {
        return left + mid + new StringBuilder(left).reverse();
    }
}
