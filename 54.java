/**
《剑指offer》上有更简洁的代码，不过实在很难记住，也很容易写错。
这里记录一种易于理解和记忆的思路。矩阵周围仿佛有四堵墙，遍历一行或一列后对应的墙移动一格，然后判定循环条件即可。
**/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();

        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) return result;

        int leftWall = -1, rightWall = matrix[0].length, upWall = -1, downWall = matrix.length;
        int row = 0, col = 0;
        while (leftWall < rightWall - 1 && upWall < downWall - 1) {
            while (col < rightWall) {
                result.add(matrix[row][col++]);
            }
            col--;
            row++;
            if(++upWall >= downWall - 1) break;
            
            while (row < downWall) {
                result.add(matrix[row++][col]);
            }
            row--;
            col--;
            if(leftWall + 1>= --rightWall) break;
            
            while (col > leftWall) {
                result.add(matrix[row][col--]);
            }
            col++;
            row--;
            if(upWall + 1 >= --downWall) break;
            
            while (row > upWall) {
                result.add(matrix[row--][col]);
            }
            row++;
            col++;
            if(++leftWall >= rightWall - 1) break;
        }

        return result;
    }
}
