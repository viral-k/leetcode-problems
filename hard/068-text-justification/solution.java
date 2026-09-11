import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * Time: O(total characters)
 * Space: O(maxWidth) excluding the output
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>(); // words on the current line
        int lineLen = 0;                       // total word length, excluding spaces

        for (String word : words) {
            // line.size() accounts for one mandatory space before each new word
            if (!line.isEmpty() && lineLen + line.size() + word.length() > maxWidth) {
                result.add(flush(line, lineLen, maxWidth, false));
                line.clear();
                lineLen = 0;
            }
            line.add(word);
            lineLen += word.length();
        }

        result.add(flush(line, lineLen, maxWidth, true));
        return result;
    }

    private String flush(List<String> words, int total, int maxWidth, boolean last) {
        StringBuilder sb = new StringBuilder();

        if (last || words.size() == 1) {
            // last line and single-word lines are left-justified
            for (int i = 0; i < words.size(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(words.get(i));
            }
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            return sb.toString();
        }

        int gaps = words.size() - 1;
        int base = (maxWidth - total) / gaps;
        int extra = (maxWidth - total) % gaps;
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i));
            // the leftmost `extra` gaps take one additional space
            int width = base + (i < extra ? 1 : 0);
            for (int s = 0; s < width; s++) {
                sb.append(' ');
            }
        }
        sb.append(words.get(words.size() - 1));
        return sb.toString();
    }
}
