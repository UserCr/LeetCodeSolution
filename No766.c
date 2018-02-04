/**
注意循环条件。
**/

bool isToeplitzMatrix(int** matrix, int matrixRowSize, int *matrixColSizes) {
    int m = matrixRowSize, n = matrixColSizes[0];
    if(1 == m || 1 == n) return true;
    for(int row = 0; row < m - 1; ++row) {
        int i = row, j = 0;
        while(i + 1 < m && j + 1 < n) {
            if(matrix[i][j] != matrix[i + 1][j + 1]) return false;
            i++;
            j++;
        }
    }
    for(int col = 1; col < n - 1; ++col) {
        int i = 0, j = col;
        while(i + 1 < m && j + 1 < n) {
            if(matrix[i][j] != matrix[i + 1][j + 1]) return false;
            i++;
            j++;
        }
    }
    return true;
}
