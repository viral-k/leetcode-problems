import java.util.*;

/**
 * 1352. Product of the Last K Numbers
 * Time: O(1) per add and getProduct (amortized for add)
 * Space: O(n)
 */
class ProductOfNumbers {
    // prefix.get(i) = product of the first i numbers since the last zero.
    // A zero wipes the history: no window reaching past it can be nonzero.
    // Every stored value is a contiguous product, which the problem guarantees
    // fits in an int.
    private List<Integer> prefix = new ArrayList<>();

    public ProductOfNumbers() {
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();
        // Fewer than k numbers since the last zero: the window contains it.
        if (k >= n) {
            return 0;
        }
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}
