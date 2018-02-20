/**
水题。
**/

void swap(char* s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
}

void reverse(char* s, int i, int j) {
    while(i < j) {
        swap(s, i, j);
        i++;
        j--;
    }
}

char* reverseWords(char* s) {
    for(int left = 0, right = 0; s[left] != 0;) {
        while(s[left] == ' ') left++;
        if(s[left] == 0) break;
        right = left;
        while(s[right + 1] != 0 && s[right + 1] != ' ') right++;
        reverse(s, left, right);
        left = (right + 1);
    }
    return s;
}
