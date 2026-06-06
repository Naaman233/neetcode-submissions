class Solution {
    public int trap(int[] height) {
        int result = 0, n = height.length;

        int[] maxLeftHeight = new int[n];
        int leftPointer = 0;

        for (int i = 0; i < n; i++){
            if (i == 0) {
                maxLeftHeight[i] = 0;
            }else {
                maxLeftHeight[i] = leftPointer;
            }
            if (leftPointer < height[i]) {
                leftPointer = height[i];
            }
        }

        int[] maxRightHeight = new int[n];
        int rightPointer = 0;
        for (int i = n -1; i > 0; i--) {
            if (i == n - 1) {
                maxRightHeight[i] = 0;
            }else {
                maxRightHeight[i] = rightPointer;
            }

            if (rightPointer < height[i]) {
                rightPointer = height[i];
            }
        }

        for (int i = 0; i < n; i++){
            if (height[i] < Math.min(maxLeftHeight[i],maxRightHeight[i])) {
                result = result + (Math.min(maxLeftHeight[i],maxRightHeight[i]) - height[i]);
            }
        }

        return result;
    }
}
