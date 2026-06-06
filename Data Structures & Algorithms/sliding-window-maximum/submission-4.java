class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        int left = 0, right = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while (right < n) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offer(right);
            if (left > queue.peekFirst()) {
                queue.pollFirst();
            }

            if (right + 1 >= k) {
                result[left] = nums[queue.peekFirst()];
                left++;
            }
            right++;
        }

        return result;
    }
}
