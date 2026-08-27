/**
 * 3720. Lexicographically Smallest Permutation Greater Than Target
 * Time: O(26 * n)
 * Space: O(n)
 */
class Solution {
    public String smallestPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // Longest prefix of target that s's letters can spell.
        int matched = 0;
        while (matched < n && counts[target.charAt(matched) - 'a'] > 0) {
            counts[target.charAt(matched) - 'a']--;
            matched++;
        }

        // Prefer the longest shared prefix: deviating later gives a smaller result.
        for (int p = matched; p >= 0; p--) {
            // Roll characters back into the pool until counts match a prefix of length p.
            while (matched > p) {
                matched--;
                counts[target.charAt(matched) - 'a']++;
            }

            if (p >= n) {
                continue; // a full match is equal, not strictly greater
            }

            // Smallest available letter strictly greater than target[p].
            for (int c = target.charAt(p) - 'a' + 1; c < 26; c++) {
                if (counts[c] > 0) {
                    counts[c]--;
                    StringBuilder sb = new StringBuilder();
                    sb.append(target, 0, p);
                    sb.append((char) ('a' + c));
                    for (int j = 0; j < 26; j++) {
                        for (int t = 0; t < counts[j]; t++) {
                            sb.append((char) ('a' + j));
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return "";
    }
}
