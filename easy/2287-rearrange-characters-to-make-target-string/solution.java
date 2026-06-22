/**
 * 2287. Rearrange Characters to Make Target String
 * Time: O(|s| + |target|)
 * Space: O(1)
 */
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sCount = new int[26];
        int[] targetCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < target.length(); i++) {
            targetCount[target.charAt(i) - 'a']++;
        }

        int answer = Integer.MAX_VALUE;
        for (int c = 0; c < 26; c++) {
            if (targetCount[c] > 0) {
                answer = Math.min(answer, sCount[c] / targetCount[c]);
            }
        }

        return answer;
    }
}
