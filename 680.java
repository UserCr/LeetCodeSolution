/**
水题。遇到不同字符的时候不要用简单的试探策略略过某个字符，而要分别检查略过每个字符后的结果，都不回文时才返回false。
**/

class Solution {
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s.substring(left + 1, right + 1)) ||
                        isPalindrome(s.substring(left, right));
            }
        }
        return true;
    }
}
