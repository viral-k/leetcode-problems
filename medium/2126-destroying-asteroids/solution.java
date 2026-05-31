/**
 * 2126. Destroying Asteroids
 * Time: O(n + M)
 * Space: O(M)
 */
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int maxAsteroid = 0;
        for (int asteroid : asteroids) {
            maxAsteroid = Math.max(maxAsteroid, asteroid);
        }

        int[] frequency = new int[maxAsteroid + 1];
        for (int asteroid : asteroids) {
            frequency[asteroid]++;
        }

        long currentMass = mass;

        for (int asteroidMass = 1; asteroidMass <= maxAsteroid; asteroidMass++) {
            if (frequency[asteroidMass] == 0) {
                continue;
            }

            if (currentMass < asteroidMass) {
                return false;
            }
            currentMass += (long) asteroidMass * frequency[asteroidMass];
        }

        return true;
    }
}
