from typing import List


class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        """
        2126. Destroying Asteroids
        Time: O(n + M)
        Space: O(M)
        """
        max_asteroid = max(asteroids)
        frequency = [0] * (max_asteroid + 1)

        for asteroid in asteroids:
            frequency[asteroid] += 1

        for asteroid_mass, count in enumerate(frequency):
            if count == 0:
                continue

            if mass < asteroid_mass:
                return False
            mass += asteroid_mass * count

        return True
