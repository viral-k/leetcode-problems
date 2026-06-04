class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        """
        3751. Total Waviness of Numbers in Range I
        Time: O(R * D)
        Space: O(D)
        """
        def waviness(num: int) -> int:
            digits = str(num)
            count = 0

            for index in range(1, len(digits) - 1):
                previous_digit = digits[index - 1]
                current_digit = digits[index]
                next_digit = digits[index + 1]

                if (
                    previous_digit < current_digit > next_digit
                    or previous_digit > current_digit < next_digit
                ):
                    count += 1

            return count

        return sum(waviness(num) for num in range(num1, num2 + 1))
