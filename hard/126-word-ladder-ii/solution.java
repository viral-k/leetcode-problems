import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 126. Word Ladder II
 * Time: O(n * L * 26) for the BFS, plus the output size
 * Space: O(n * L)
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> unvisited = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!unvisited.contains(endWord)) {
            return result;
        }
        unvisited.remove(beginWord);

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);
        boolean found = false;

        while (!level.isEmpty() && !found) {
            Set<String> discovered = new HashSet<>();
            for (String word : level) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }
                        chars[i] = ch;
                        String next = new String(chars);
                        if (unvisited.contains(next)) {
                            discovered.add(next);
                            // only shortest-path edges land here, since next is
                            // still unvisited and so sits on the following level
                            parents.computeIfAbsent(next, key -> new ArrayList<>()).add(word);
                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    chars[i] = original;
                }
            }
            // remove after the whole level, so every parent gets recorded
            unvisited.removeAll(discovered);
            level = discovered;
        }

        if (!found) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, result);
        return result;
    }

    private void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                           List<String> path, List<List<String>> result) {
        if (word.equals(beginWord)) {
            List<String> done = new ArrayList<>(path);
            Collections.reverse(done);
            result.add(done);
            return;
        }
        for (String prev : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(prev);
            backtrack(prev, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}
