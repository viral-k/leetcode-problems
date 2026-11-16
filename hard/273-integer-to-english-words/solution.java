/**
 * 273. Integer to English Words
 * Time: O(1), at most 4 chunks of 3 digits
 * Space: O(1)
 */
class Solution {
    private static final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] SCALES = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int divisor = 1_000_000_000;
        for (int scale = 3; scale >= 0; scale--, divisor /= 1000) {
            int n = num / divisor % 1000;
            if (n != 0) { // a zero chunk adds nothing, not even its scale word
                appendChunk(sb, n);
                add(sb, SCALES[scale]);
            }
        }
        return sb.toString();
    }

    // Words for 1 <= n <= 999.
    private void appendChunk(StringBuilder sb, int n) {
        int hundreds = n / 100, rest = n % 100;
        if (hundreds != 0) {
            add(sb, ONES[hundreds]);
            add(sb, "Hundred");
        }
        if (rest < 20) {
            add(sb, ONES[rest]);
        } else {
            add(sb, TENS[rest / 10]);
            add(sb, ONES[rest % 10]);
        }
    }

    // Appends a word with a single separating space; empty words are skipped.
    private void add(StringBuilder sb, String word) {
        if (word.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(word);
    }
}
