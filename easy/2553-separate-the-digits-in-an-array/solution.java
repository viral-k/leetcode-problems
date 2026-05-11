import java.util.ArrayList;
import java.util.List;

/**
 * 2553. Separate the Digits in an Array
 * Time: O(d)
 * Space: O(d)
 */
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int num : nums) {
            for (char digit : String.valueOf(num).toCharArray()) {
                digits.add(digit - '0');
            }
        }

        int[] answer = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            answer[i] = digits.get(i);
        }

        return answer;
    }
}
