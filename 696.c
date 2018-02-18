/**
水题。注意一下01状态变化就没有问题。
**/

int countBinarySubstrings(char* s) {
    int countZero = s[0] == '0' ? 1 : 0, countOne = s[0] == '1' ? 1 : 0, count = 0;
    for(int i = 1; s[i] != 0; ++i) {
        if(s[i] == '0') {
            if(s[i - 1] == '1') countZero = 0;
            countZero++;
            if(countZero <= countOne) count++;
        } else {
            if(s[i - 1] == '0') countOne = 0;
            countOne++;
            if(countOne <= countZero) count++;
        }
    }
    return count;
}
