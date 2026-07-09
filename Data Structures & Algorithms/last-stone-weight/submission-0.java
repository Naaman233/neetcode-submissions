class Solution {
    public int lastStoneWeight(int[] stones) {
        int size = stones.length;

        while (size > 1) {
            Arrays.sort(stones, 0, size);

            stones[size - 2] = stones[size - 1] - stones[size - 2];
            size--;
        }

        return stones[0];
    }
}
