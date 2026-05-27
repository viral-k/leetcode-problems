class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        """
        3121. Count the Number of Special Characters II
        Time: O(n)
        Space: O(1)
        """
        n = len(word)
        last_lowercase = [-1] * 26
        first_uppercase = [n] * 26

        for index, char in enumerate(word):
            if char.islower():
                letter = ord(char) - ord("a")
                last_lowercase[letter] = index
            else:
                letter = ord(char) - ord("A")
                first_uppercase[letter] = min(first_uppercase[letter], index)

        answer = 0
        for letter in range(26):
            if (
                last_lowercase[letter] != -1
                and first_uppercase[letter] != n
                and last_lowercase[letter] < first_uppercase[letter]
            ):
                answer += 1

        return answer
