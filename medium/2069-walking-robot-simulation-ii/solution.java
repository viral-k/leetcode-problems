/**
 * 2069. Walking Robot Simulation II
 * Time: O(1) per operation
 * Space: O(1)
 */
class Robot {
    private int width, height;
    private int perimeter;
    private int index;
    private boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
        this.index = 0;
        this.moved = false;
    }

    public void step(int num) {
        index = (index + num) % perimeter;
        moved = true;
    }

    public int[] getPos() {
        int i = index;
        int w = width, h = height;

        if (i < w) {
            return new int[]{i, 0};
        }
        i -= w - 1;
        if (i < h) {
            return new int[]{w - 1, i};
        }
        i -= h - 1;
        if (i < w) {
            return new int[]{w - 1 - i, h - 1};
        }
        i -= w - 1;
        return new int[]{0, h - 1 - i};
    }

    public String getDir() {
        int i = index;
        int w = width, h = height;

        if (i == 0) {
            return moved ? "South" : "East";
        }
        if (i < w) {
            return "East";
        }
        if (i < w + h - 1) {
            return "North";
        }
        if (i < 2 * w + h - 2) {
            return "West";
        }
        return "South";
    }
}
