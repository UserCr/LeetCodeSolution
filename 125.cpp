/**
水题。
**/

class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0 , j = s.length() - 1;
        while(i < j) {
            while(!isLegal(s[i]) && i < s.length()) i++;
            while(!isLegal(s[j]) && j > 0) j--;
            if(i < j && toUpCase(s[i++]) != toUpCase(s[j--])) return false;
        }
        return true;
    }
private:
    bool isLegal(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
    char toUpCase(char c) {
        if(c >= 'a' && c <= 'z') {
            return c + 'A' - 'a';
        }
        return c;
    }
};
