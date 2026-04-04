/**
 * 2075. Decode the Slanted Ciphertext
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) {
            return "";
        }

        int cols = encodedText.length() / rows;
        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int row = 0, col = startCol;
            while (row < rows && col < cols) {
                result.append(encodedText.charAt(row * cols + col));
                row++;
                col++;
            }
        }

        int end = result.length();
        while (end > 0 && result.charAt(end - 1) == ' ') {
            end--;
        }

        return result.substring(0, end);
    }
}
