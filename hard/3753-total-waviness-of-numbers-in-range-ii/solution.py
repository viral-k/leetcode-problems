from functools import lru_cache
from typing import Tuple


class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        """
        3753. Total Waviness of Numbers in Range II
        Time: O(D * 10 * 11 * 11 * 10)
        Space: O(D * 11 * 11)
        """
        return self._count_up_to(num2) - self._count_up_to(num1 - 1)

    def _count_up_to(self, limit: int) -> int:
        if limit <= 0:
            return 0

        digits = list(map(int, str(limit)))

        @lru_cache(None)
        def dp(
            position: int,
            tight: bool,
            started: bool,
            previous_previous_digit: int,
            previous_digit: int,
        ) -> Tuple[int, int]:
            if position == len(digits):
                return 1, 0

            upper_bound = digits[position] if tight else 9
            total_numbers = 0
            total_waviness = 0

            for digit in range(upper_bound + 1):
                next_tight = tight and digit == upper_bound

                if not started and digit == 0:
                    count, waviness = dp(position + 1, next_tight, False, -1, -1)
                    total_numbers += count
                    total_waviness += waviness
                    continue

                if not started:
                    count, waviness = dp(position + 1, next_tight, True, -1, digit)
                    total_numbers += count
                    total_waviness += waviness
                    continue

                if previous_previous_digit == -1:
                    count, waviness = dp(
                        position + 1,
                        next_tight,
                        True,
                        previous_digit,
                        digit,
                    )
                    total_numbers += count
                    total_waviness += waviness
                    continue

                contribution = int(
                    previous_previous_digit < previous_digit > digit
                    or previous_previous_digit > previous_digit < digit
                )
                count, waviness = dp(position + 1, next_tight, True, previous_digit, digit)
                total_numbers += count
                total_waviness += waviness + contribution * count

            return total_numbers, total_waviness

        return dp(0, True, False, -1, -1)[1]
