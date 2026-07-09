class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int weight : stones) {
            heap.offer(weight);
        }

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();

            if (first != second) {
                heap.offer(first - second);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }
}
