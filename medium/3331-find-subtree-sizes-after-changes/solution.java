import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3331. Find Subtree Sizes After Changes
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int x = 1; x < n; x++) children[parent[x]].add(x);

        int[] newParent = parent.clone();
        int[] last = new int[26];        // deepest node on the current path with each letter
        Arrays.fill(last, -1);
        int[] saved = new int[n];        // last[s[x]] before x was entered
        int[] order = new int[n];        // original preorder
        int k = 0;
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;
        while (top > 0) {
            int x = stack[--top];
            if (x >= 0) {                // enter
                order[k++] = x;
                int c = s.charAt(x) - 'a';
                if (last[c] != -1) newParent[x] = last[c];
                saved[x] = last[c];
                last[c] = x;
                stack[top++] = ~x;
                for (int child : children[x]) stack[top++] = child;
            } else {                     // exit
                x = ~x;
                last[s.charAt(x) - 'a'] = saved[x];
            }
        }

        // New parents are original ancestors, so reversed preorder puts
        // every child before its new parent.
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int i = n - 1; i > 0; i--) {
            int x = order[i];
            size[newParent[x]] += size[x];
        }
        return size;
    }
}
