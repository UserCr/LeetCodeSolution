/**
水题。
**/

int lengthOfLastWord(char* s) {
    int wordlen = 0, slen = strlen(s);
    int i = slen - 1;
    while(s[i] == ' ' && i >= 0) {
        i--;
    }
    while(s[i] != ' ' && i >= 0) {
        wordlen++;
        i--;
    }
    return wordlen;
}
