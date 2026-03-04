import java.util.*;

/**
 * 49. Group Anagrams
 * Time: O(n × k)
 * Space: O(n × k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            
            String key = Arrays.toString(count);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(groups.values());
    }
}
