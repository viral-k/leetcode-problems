class ProductOfNumbers:
    """
    1352. Product of the Last K Numbers
    Time: O(1) per add and getProduct
    Space: O(n)
    """

    def __init__(self):
        # prefix[i] = product of the first i numbers since the last zero.
        # A zero wipes the history: no window reaching past it can be nonzero.
        self.prefix = [1]

    def add(self, num: int) -> None:
        if num == 0:
            self.prefix = [1]
        else:
            self.prefix.append(self.prefix[-1] * num)

    def getProduct(self, k: int) -> int:
        # Fewer than k numbers since the last zero: the window contains it.
        if k >= len(self.prefix):
            return 0
        return self.prefix[-1] // self.prefix[-1 - k]
