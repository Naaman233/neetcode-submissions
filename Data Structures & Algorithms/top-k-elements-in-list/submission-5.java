class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for ( int i = 0; i < nums.length; i++ ) {
            int element = nums[i];
            hashMap.put(element, hashMap.getOrDefault(element,0)+1);

        }

         PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        

        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (minHeap.isEmpty() == false) {
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
}
