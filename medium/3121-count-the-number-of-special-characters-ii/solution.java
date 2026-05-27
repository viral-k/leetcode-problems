/**
 * 3121. Count the Number of Special Characters II
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] lastLowercase = new int[26];
        int[] firstUppercase = new int[26];

        for (int letter = 0; letter < 26; letter++) {
            lastLowercase[letter] = -1;
            firstUppercase[letter] = n;
        }

        for (int index = 0; index < n; index++) {
            char current = word.charAt(index);
            if (Character.isLowerCase(current)) {
                int letter = current - 'a';
                lastLowercase[letter] = index;
            } else {
                int letter = current - 'A';
                firstUppercase[letter] = Math.min(firstUppercase[letter], index);
            }
        }

        int answer = 0;
        for (int letter = 0; letter < 26; letter++) {
            if (
                lastLowercase[letter] != -1
                    && firstUppercase[letter] != n
                    && lastLowercase[letter] < firstUppercase[letter]
            ) {
                answer++;
            }
        }

        return answer;
    }
}
