/**
水题。
**/
int firstUniqChar(char* s) {
    int bucket[26];
    for(int i = 0; i < 26; i++) {
        bucket[i] = -1;
    }
    for(int i = 0; s[i] != 0; ++i) {
        if(bucket[(int)(s[i] - 'a')] == -1) bucket[(int)(s[i] - 'a')] = i;
        else if(bucket[(int)(s[i] - 'a')] >= 0) bucket[(int)(s[i] - 'a')] = -2;
    }
    int min_index = -1;
    for(int i = 0; i < 26; i++) {
        if(bucket[i] >= 0 && (bucket[i] < min_index || min_index == -1)) min_index = bucket[i];
    }
    return min_index;
}
