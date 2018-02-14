/**
水题。
**/

bool checkRecord(char* s) {
    int countA = 0, countL = 0;
    for(int i = 0; s[i] != 0; ++i) {
        if('A' == s[i]) {
            countA++;
            countL = 0;
            if(countA > 1) return false;
        } else if('L' == s[i]) {
            countL++;
            if(countL > 2) return false;
        } else {
            countL = 0;
        }
    }
    return true;
}
