class Robot:
    """
    2069. Walking Robot Simulation II
    Time: O(1) per operation
    Space: O(1)
    """

    def __init__(self, width: int, height: int):
        self.width = width
        self.height = height
        self.perimeter = 2 * (width + height - 2)
        self.index = 0

    def step(self, num: int) -> None:
        self.index = (self.index + num) % self.perimeter

    def getPos(self) -> list[int]:
        i = self.index
        w, h = self.width, self.height

        if i < w:
            return [i, 0]
        i -= w - 1
        if i < h:
            return [w - 1, i]
        i -= h - 1
        if i < w:
            return [w - 1 - i, h - 1]
        i -= w - 1
        return [0, h - 1 - i]

    def getDir(self) -> str:
        i = self.index
        w, h = self.width, self.height

        if i == 0:
            return "East"
        if i < w:
            return "East"
        if i < w + h - 1:
            return "North"
        if i < 2 * w + h - 2:
            return "West"
        return "South"
