/**
水题。可以用hashmap，不过效率略低，因为字符全部都是ascii，所以可以用数组代替。
**/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineSet = new int[256];
        for(char c : magazine.toCharArray()) {
            magazineSet[(int)c]++;
        }
        for(char c : ransomNote.toCharArray()) {
            if(--magazineSet[(int)c] < 0) return false;
        }
        return true;
    }
}
