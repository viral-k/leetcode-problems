/**
 * 2409. Count Days Spent Together
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    // cumulative days before each month in a non-leap year
    private static final int[] PREFIX =
            {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int lo = Math.max(ordinal(arriveAlice), ordinal(arriveBob));
        int hi = Math.min(ordinal(leaveAlice), ordinal(leaveBob));

        // closed intervals overlap on [lo, hi]; empty when hi < lo
        return Math.max(0, hi - lo + 1);
    }

    private int ordinal(String date) {
        // fixed width "MM-DD", so read the digits directly
        int month = (date.charAt(0) - '0') * 10 + (date.charAt(1) - '0');
        int day = (date.charAt(3) - '0') * 10 + (date.charAt(4) - '0');
        return PREFIX[month - 1] + day;
    }
}
