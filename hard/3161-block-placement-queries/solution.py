from typing import List


class FenwickTree:
    def __init__(self, size: int) -> None:
        self.size = size
        self.tree = [0] * (size + 1)

    def add(self, index: int, delta: int) -> None:
        while index <= self.size:
            self.tree[index] += delta
            index += index & -index

    def prefix_sum(self, index: int) -> int:
        total = 0
        while index > 0:
            total += self.tree[index]
            index -= index & -index
        return total

    def find_by_order(self, order: int) -> int:
        index = 0
        bit = 1 << (self.size.bit_length() - 1)

        while bit:
            next_index = index + bit
            if next_index <= self.size and self.tree[next_index] < order:
                index = next_index
                order -= self.tree[next_index]
            bit >>= 1

        return index + 1


class SegmentTree:
    def __init__(self, size: int) -> None:
        self.size = 1
        while self.size < size:
            self.size *= 2
        self.tree = [0] * (2 * self.size)

    def update(self, index: int, value: int) -> None:
        index += self.size
        self.tree[index] = value
        index //= 2

        while index:
            self.tree[index] = max(self.tree[2 * index], self.tree[2 * index + 1])
            index //= 2

    def query(self, left: int, right: int) -> int:
        left += self.size
        right += self.size
        answer = 0

        while left <= right:
            if left % 2 == 1:
                answer = max(answer, self.tree[left])
                left += 1
            if right % 2 == 0:
                answer = max(answer, self.tree[right])
                right -= 1
            left //= 2
            right //= 2

        return answer


class Solution:
    def getResults(self, queries: List[List[int]]) -> List[bool]:
        """
        3161. Block Placement Queries
        Time: O(q log M)
        Space: O(M)
        """
        max_coordinate = max(query[1] for query in queries)
        fenwick = FenwickTree(max_coordinate + 1)
        segment_tree = SegmentTree(max_coordinate + 1)

        fenwick.add(1, 1)
        obstacle_count = 1
        results = []

        for query in queries:
            if query[0] == 1:
                x = query[1]

                before_count = fenwick.prefix_sum(x)
                previous_obstacle = fenwick.find_by_order(before_count) - 1

                if before_count < obstacle_count:
                    next_obstacle = fenwick.find_by_order(before_count + 1) - 1
                    segment_tree.update(next_obstacle, next_obstacle - x)

                segment_tree.update(x, x - previous_obstacle)
                fenwick.add(x + 1, 1)
                obstacle_count += 1
            else:
                x, size = query[1], query[2]
                count_until_x = fenwick.prefix_sum(x + 1)
                previous_obstacle = fenwick.find_by_order(count_until_x) - 1

                best_completed_gap = segment_tree.query(0, x)
                tail_gap = x - previous_obstacle
                results.append(max(best_completed_gap, tail_gap) >= size)

        return results
