class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int result = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                result = Math.max(result,dfs(matrix,i,j,memo));
            }
        }

        return result;
    }

    int dfs(int[][] matrix, int row, int col, int[][] memo) {

        if (memo[row][col] != 0){
            return memo[row][col];
        }

        int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
        int res = 1;
        int m = matrix.length, n = matrix[0].length;
        for(int[] dir : direction) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
            matrix[newRow][newCol] > matrix[row][col]) {
                res = Math.max(res , 1 + dfs(matrix, newRow, newCol, memo));
            }
        }
        memo[row][col] = res;
        return res;
    }
}
