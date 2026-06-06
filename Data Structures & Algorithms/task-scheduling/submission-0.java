class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencyCount = new int[26];

        for (char c : tasks) {
            frequencyCount[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> {
            return b - a;
        });
        for (int count : frequencyCount){
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int currentFrequency = maxHeap.poll();

                if (currentFrequency - 1 > 0) {
                    cooldownQueue.offer(new int[]{currentFrequency-1,time+n});
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time){
                 maxHeap.offer(cooldownQueue.poll()[0]);
            }

        }
        return time;
    }
}
