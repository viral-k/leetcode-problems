/**
 * 3753. Total Waviness of Numbers in Range II
 * Time: O(D * 10 * 11 * 11 * 10)
 * Space: O(D * 11 * 11)
 */
class Solution {
    private char[] digits;
    private boolean[][][][] seen;
    private long[][][][] memoCount;
    private long[][][][] memoWaviness;

    public long totalWaviness(long num1, long num2) {
        return countUpTo(num2) - countUpTo(num1 - 1);
    }

    private long countUpTo(long limit) {
        if (limit <= 0) {
            return 0;
        }

        digits = Long.toString(limit).toCharArray();
        int n = digits.length;
        seen = new boolean[n][2][11][11];
        memoCount = new long[n][2][11][11];
        memoWaviness = new long[n][2][11][11];

        return dp(0, true, false, -1, -1).waviness;
    }

    private Result dp(
        int position,
        boolean tight,
        boolean started,
        int previousPreviousDigit,
        int previousDigit
    ) {
        if (position == digits.length) {
            return new Result(1, 0);
        }

        int startedIndex = started ? 1 : 0;
        int previousPreviousIndex = previousPreviousDigit + 1;
        int previousIndex = previousDigit + 1;

        if (!tight && seen[position][startedIndex][previousPreviousIndex][previousIndex]) {
            return new Result(
                memoCount[position][startedIndex][previousPreviousIndex][previousIndex],
                memoWaviness[position][startedIndex][previousPreviousIndex][previousIndex]
            );
        }

        int upperBound = tight ? digits[position] - '0' : 9;
        long totalCount = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= upperBound; digit++) {
            boolean nextTight = tight && digit == upperBound;
            Result result;
            int contribution = 0;

            if (!started && digit == 0) {
                result = dp(position + 1, nextTight, false, -1, -1);
            } else if (!started) {
                result = dp(position + 1, nextTight, true, -1, digit);
            } else if (previousPreviousDigit == -1) {
                result = dp(position + 1, nextTight, true, previousDigit, digit);
            } else {
                if (
                    (previousPreviousDigit < previousDigit && previousDigit > digit)
                        || (previousPreviousDigit > previousDigit && previousDigit < digit)
                ) {
                    contribution = 1;
                }
                result = dp(position + 1, nextTight, true, previousDigit, digit);
            }

            totalCount += result.count;
            totalWaviness += result.waviness + (long) contribution * result.count;
        }

        if (!tight) {
            seen[position][startedIndex][previousPreviousIndex][previousIndex] = true;
            memoCount[position][startedIndex][previousPreviousIndex][previousIndex] = totalCount;
            memoWaviness[position][startedIndex][previousPreviousIndex][previousIndex] = totalWaviness;
        }

        return new Result(totalCount, totalWaviness);
    }

    private static class Result {
        long count;
        long waviness;

        Result(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }
}
