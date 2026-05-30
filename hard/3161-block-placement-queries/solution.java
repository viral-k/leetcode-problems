import java.util.ArrayList;
import java.util.List;

/**
 * 3161. Block Placement Queries
 * Time: O(q log M)
 * Space: O(M)
 */
class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int maxCoordinate = 0;
        for (int[] query : queries) {
            maxCoordinate = Math.max(maxCoordinate, query[1]);
        }

        FenwickTree fenwick = new FenwickTree(maxCoordinate + 1);
        SegmentTree segmentTree = new SegmentTree(maxCoordinate + 1);
        fenwick.add(1, 1);
        int obstacleCount = 1;

        List<Boolean> results = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int x = query[1];
                int beforeCount = fenwick.prefixSum(x);
                int previousObstacle = fenwick.findByOrder(beforeCount) - 1;

                if (beforeCount < obstacleCount) {
                    int nextObstacle = fenwick.findByOrder(beforeCount + 1) - 1;
                    segmentTree.update(nextObstacle, nextObstacle - x);
                }

                segmentTree.update(x, x - previousObstacle);
                fenwick.add(x + 1, 1);
                obstacleCount++;
            } else {
                int x = query[1];
                int size = query[2];
                int countUntilX = fenwick.prefixSum(x + 1);
                int previousObstacle = fenwick.findByOrder(countUntilX) - 1;

                int bestCompletedGap = segmentTree.query(0, x);
                int tailGap = x - previousObstacle;
                results.add(Math.max(bestCompletedGap, tailGap) >= size);
            }
        }

        return results;
    }

    private static class FenwickTree {
        private final int size;
        private final int[] tree;

        FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        void add(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int prefixSum(int index) {
            int total = 0;
            while (index > 0) {
                total += tree[index];
                index -= index & -index;
            }
            return total;
        }

        int findByOrder(int order) {
            int index = 0;
            int bit = Integer.highestOneBit(size);

            while (bit > 0) {
                int nextIndex = index + bit;
                if (nextIndex <= size && tree[nextIndex] < order) {
                    index = nextIndex;
                    order -= tree[nextIndex];
                }
                bit >>= 1;
            }

            return index + 1;
        }
    }

    private static class SegmentTree {
        private final int size;
        private final int[] tree;

        SegmentTree(int length) {
            int currentSize = 1;
            while (currentSize < length) {
                currentSize *= 2;
            }
            this.size = currentSize;
            this.tree = new int[2 * size];
        }

        void update(int index, int value) {
            index += size;
            tree[index] = value;
            index /= 2;

            while (index > 0) {
                tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
                index /= 2;
            }
        }

        int query(int left, int right) {
            left += size;
            right += size;
            int answer = 0;

            while (left <= right) {
                if (left % 2 == 1) {
                    answer = Math.max(answer, tree[left]);
                    left++;
                }
                if (right % 2 == 0) {
                    answer = Math.max(answer, tree[right]);
                    right--;
                }
                left /= 2;
                right /= 2;
            }

            return answer;
        }
    }
}
