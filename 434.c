/**
水题。
**/

int countSegments(char* s) {
    if(s[0] == 0) return 0;
    
    int count = s[0] == ' ' ? 0 : 1;
    bool readingWord = s[0] != ' ';
    for(int i = 0; s[i] != 0; i++) {
        if(readingWord && s[i] == ' ') {
            readingWord = false;
        } else if(!readingWord && s[i] != ' ') {
            count++;
            readingWord = true;
        }
    }
    
    return count;
}
