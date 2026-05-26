class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        """
        3120. Count the Number of Special Characters I
        Time: O(n)
        Space: O(1)
        """
        lowercase = set()
        uppercase = set()

        for char in word:
            if char.islower():
                lowercase.add(char)
            else:
                uppercase.add(char.lower())

        return len(lowercase & uppercase)
