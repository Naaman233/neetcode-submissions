class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int weight : stones) {
            heap.offer(weight);
        }

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            int result = h(first,second);
            if (result != 0) heap.offer(result);
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }

    private int h(int x, int y) {
        if (x == y) return 0;
        return x > y ? x - y : y - x;
    }
}
