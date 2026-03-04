from typing import List
from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        49. Group Anagrams
        Time: O(n × k)
        Space: O(n × k)
        """
        groups = defaultdict(list)
        
        for s in strs:
            count = [0] * 26
            for ch in s:
                count[ord(ch) - 97] += 1
            groups[tuple(count)].append(s)
        
        return list(groups.values())
