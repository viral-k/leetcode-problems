import java.util.HashSet;
import java.util.Set;

/**
 * 3120. Count the Number of Special Characters I
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lowercase = new HashSet<>();
        Set<Character> uppercase = new HashSet<>();

        for (int index = 0; index < word.length(); index++) {
            char current = word.charAt(index);
            if (Character.isLowerCase(current)) {
                lowercase.add(current);
            } else {
                uppercase.add(Character.toLowerCase(current));
            }
        }

        int answer = 0;
        for (char letter : lowercase) {
            if (uppercase.contains(letter)) {
                answer++;
            }
        }

        return answer;
    }
}
