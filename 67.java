/**
水题。
**/

class Solution {
    private int bitAdd(char bit1, char bit2, int add) {
        return bit1 - '0' + bit2 - '0' + add;
    }

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int add = 0, bitAddResult;
        while (i >= 0 && j >= 0) {
            bitAddResult = bitAdd(a.charAt(i--), b.charAt(j--), add);
            stringBuilder.insert(0, (char) (bitAddResult % 2 + '0'));
            add = bitAddResult / 2;
        }
        while (i >= 0) {
            bitAddResult = bitAdd(a.charAt(i--), '0', add);
            stringBuilder.insert(0, (char) (bitAddResult % 2 + '0'));
            add = bitAddResult / 2;
        }
        while (j >= 0) {
            bitAddResult = bitAdd(b.charAt(j--), '0', add);
            stringBuilder.insert(0, (char) (bitAddResult % 2 + '0'));
            add = bitAddResult / 2;
        }
        if (add > 0) stringBuilder.insert(0, '1');

        return stringBuilder.toString();
    }
}
