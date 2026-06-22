/**
 * 1189. Maximum Number of Balloons
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }

        int answer = Math.min(count['b' - 'a'], count['a' - 'a']);
        answer = Math.min(answer, count['l' - 'a'] / 2);
        answer = Math.min(answer, count['o' - 'a'] / 2);
        answer = Math.min(answer, count['n' - 'a']);

        return answer;
    }
}
