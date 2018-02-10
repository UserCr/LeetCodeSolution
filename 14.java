/**
水题。
**/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        StringBuilder stringBuilder = new StringBuilder();
        int row = 0, col = 0;
        char cur_ch = '\0';
        while(col < strs[row].length()) {
            if(0 == row) cur_ch = strs[row].charAt(col);
            if(strs[row].charAt(col) != cur_ch) return stringBuilder.toString();
            else row++;
            if(row == strs.length) {
                stringBuilder.append(cur_ch);
                row = 0;
                col++;
            }
        }
        return stringBuilder.toString();
    }
}
