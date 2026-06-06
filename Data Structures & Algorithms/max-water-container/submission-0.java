class Solution {
    public int maxArea(int[] heights) {
        int i = 0 , j = heights.length -1;
        int result = 0;
        while (i < j) {
            int length = Math.min(heights[i],heights[j]);
            int breadth = j - i;

            int area = length * breadth;
            result = Math.max(result,area);
            if (heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }

        return result;
    }
}
