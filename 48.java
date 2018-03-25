/**
水题。
**/

class Solution {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 1) return;
        for (int row = 0; row < matrix.length / 2; ++row) {
            for (int col = row; col < matrix.length - row - 1; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - col - 1][row];
                matrix[matrix.length - col - 1][row] = matrix[matrix.length - row - 1][matrix.length - col - 1];
                matrix[matrix.length - row - 1][matrix.length - col - 1] = matrix[col][matrix.length - row - 1];
                matrix[col][matrix.length - row - 1] = temp;
            }
        }
    }
}
