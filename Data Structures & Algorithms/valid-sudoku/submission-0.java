class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean output = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] != '.') {
                    output = isSudokuValid(board,i,j);
                }
                if (!output) {
                    return false;
                }
            }
        }

        return true;
    }


    static boolean isSudokuValid(char[][] board, int row, int col) {

        char c = board[row][col];
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == c) return false;
            if (i != col && board[row][i] == c) return false;
        }

        int subrowgrid = (row/3)*3;
        int subcolgrid = (col/3)*3;

        for (int i = subrowgrid; i < subrowgrid+3; i++) {
            for (int j = subcolgrid; j < subcolgrid+3; j++) {
                if (board[i][j] == c && (i != row && j != col)) return false;
            }
        }

        return true;
    }
}
