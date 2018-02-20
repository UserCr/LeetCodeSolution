/**
水题。
**/

void swap(char* s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] =temp;
}

void reverse(char* s, int i, int j) {
    while(i < j) {
        swap(s, i, j);
        i++;
        j--;
    }
}

char* reverseStr(char* s, int k) {
    const int length = strlen(s);
    for(int left = 0; left < length;) {
        int right = left + k - 1 < length ? left + k - 1 : length - 1;
        reverse(s, left, right);
        left += (k * 2);
    }
    return s;
}
