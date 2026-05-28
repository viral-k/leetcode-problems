/**
 * 3093. Longest Common Suffix Queries
 * Time: O(total container length + total query length)
 * Space: O(total container length)
 */
class Solution {
    private int[][] children;
    private int[] bestIndex;
    private int[] bestLength;
    private int nodeCount;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int maxNodes = 1;
        for (String word : wordsContainer) {
            maxNodes += word.length();
        }

        children = new int[maxNodes][26];
        bestIndex = new int[maxNodes];
        bestLength = new int[maxNodes];
        nodeCount = 1;

        for (int node = 0; node < maxNodes; node++) {
            bestIndex[node] = -1;
            bestLength[node] = Integer.MAX_VALUE;
        }

        for (int index = 0; index < wordsContainer.length; index++) {
            insert(wordsContainer[index], index);
        }

        int[] answer = new int[wordsQuery.length];
        for (int index = 0; index < wordsQuery.length; index++) {
            answer[index] = query(wordsQuery[index]);
        }

        return answer;
    }

    private void insert(String word, int wordIndex) {
        int node = 0;
        int wordLength = word.length();
        updateBest(node, wordIndex, wordLength);

        for (int index = wordLength - 1; index >= 0; index--) {
            int letter = word.charAt(index) - 'a';
            if (children[node][letter] == 0) {
                children[node][letter] = nodeCount++;
            }
            node = children[node][letter];
            updateBest(node, wordIndex, wordLength);
        }
    }

    private int query(String word) {
        int node = 0;
        int result = bestIndex[node];

        for (int index = word.length() - 1; index >= 0; index--) {
            int letter = word.charAt(index) - 'a';
            if (children[node][letter] == 0) {
                break;
            }
            node = children[node][letter];
            result = bestIndex[node];
        }

        return result;
    }

    private void updateBest(int node, int wordIndex, int wordLength) {
        if (
            wordLength < bestLength[node]
                || (wordLength == bestLength[node] && wordIndex < bestIndex[node])
        ) {
            bestLength[node] = wordLength;
            bestIndex[node] = wordIndex;
        }
    }
}
