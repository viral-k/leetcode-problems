import java.util.*;

/**
 * 3629. Minimum Jumps to Reach End via Prime Teleportation
 * Time: O(M log log M + n log M), M = max(nums)
 * Space: O(M + n log M)
 */
class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int[] spf = buildSpf(maxValue);
        Set<Integer> primeSources = new HashSet<>();
        for (int num : nums) {
            if (isPrime(num, spf)) {
                primeSources.add(num);
            }
        }

        Map<Integer, List<Integer>> teleports = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int factor : primeFactors(nums[i], spf)) {
                if (primeSources.contains(factor)) {
                    teleports.computeIfAbsent(factor, key -> new ArrayList<>()).add(i);
                }
            }
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int nextDistance = distance[i] + 1;

            int left = i - 1;
            if (left >= 0 && distance[left] == -1) {
                if (left == n - 1) {
                    return nextDistance;
                }
                distance[left] = nextDistance;
                queue.offer(left);
            }

            int right = i + 1;
            if (right < n && distance[right] == -1) {
                if (right == n - 1) {
                    return nextDistance;
                }
                distance[right] = nextDistance;
                queue.offer(right);
            }

            int value = nums[i];
            if (primeSources.contains(value)) {
                List<Integer> destinations = teleports.getOrDefault(value, Collections.emptyList());
                for (int nei : destinations) {
                    if (nei != i && distance[nei] == -1) {
                        if (nei == n - 1) {
                            return nextDistance;
                        }
                        distance[nei] = nextDistance;
                        queue.offer(nei);
                    }
                }
                destinations.clear();
            }
        }

        return distance[n - 1];
    }

    private int[] buildSpf(int maxValue) {
        int[] spf = new int[maxValue + 1];
        for (int i = 0; i <= maxValue; i++) {
            spf[i] = i;
        }

        if (maxValue >= 1) {
            spf[1] = 1;
        }

        for (int factor = 2; factor * factor <= maxValue; factor++) {
            if (spf[factor] == factor) {
                for (int multiple = factor * factor; multiple <= maxValue; multiple += factor) {
                    if (spf[multiple] == multiple) {
                        spf[multiple] = factor;
                    }
                }
            }
        }

        return spf;
    }

    private boolean isPrime(int num, int[] spf) {
        return num >= 2 && spf[num] == num;
    }

    private List<Integer> primeFactors(int num, int[] spf) {
        List<Integer> factors = new ArrayList<>();

        while (num > 1) {
            int factor = spf[num];
            factors.add(factor);
            while (num % factor == 0) {
                num /= factor;
            }
        }

        return factors;
    }
}
