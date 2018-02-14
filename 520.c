/**
水题。
**/

bool isCapital(char c) {
    return c >= 'A' && c <= 'Z';
}

bool detectCapitalUse(char* word) {
    int count = 0;
    bool firstCapital = isCapital(word[0]);
    
    for(int i = 0; word[i] != 0; ++i) {
        if(isCapital(word[i])) {
            count++;
        }
    }
    
    return (strlen(word) == count) || (0 == count) || (firstCapital && 1 == count);
}
