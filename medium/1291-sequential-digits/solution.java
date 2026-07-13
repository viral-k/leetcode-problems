import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1291. Sequential Digits
 * Time: O(1)  (36 fixed candidates)
 * Space: O(1)
 */
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();
        for (int length = 2; length <= 9; length++) {
            for (int i = 0; i + length <= 9; i++) {
                int num = Integer.parseInt(digits.substring(i, i + length));
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
