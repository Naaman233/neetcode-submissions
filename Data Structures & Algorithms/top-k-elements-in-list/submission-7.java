class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashmap.put(num, hashmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b) -> {
            return a.getValue() - b.getValue();
        });

        for (Map.Entry<Integer,Integer> entry : hashmap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll().getKey();
        }

        return result;
    }
}
