import java.util.*;

/**
 * 874. Walking Robot Simulation
 * Time: O(n + m) where n = total steps, m = obstacles
 * Space: O(m)
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int x = 0, y = 0;
        int d = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                d = (d + 3) % 4;
            } else if (cmd == -1) {
                d = (d + 1) % 4;
            } else {
                int dx = directions[d][0];
                int dy = directions[d][1];

                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx;
                    int ny = y + dy;

                    if (obstacleSet.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}
