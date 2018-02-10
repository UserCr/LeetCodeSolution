/**
水题。
**/

class Solution {
public:
    string reverseVowels(string s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(i < j && !isVowel(s[i])) i++;
            while(i < j && !isVowel(s[j])) j--;
            if(i < j) {
                char temp = s[i];
                s[i++] = s[j];
                s[j--] = temp;
            }
        }
        return s;
    }
private:
    bool isVowel(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c ||
               'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c;
    }
};
