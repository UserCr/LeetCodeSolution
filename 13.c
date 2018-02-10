/**
水题。需要了解一下罗马数字表示法。
**/

int romanCharacterToInt(char c) {
    switch(c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
    }
    return 0;
}

int romanToInt(char* s) {
    char ch = s[0];
    int num = 0, sum = 0;
    for(int i = 0; s[i] != 0; i++) {
        if(s[i] == ch) {
            sum += romanCharacterToInt(ch);
        } else {
            int chValue = romanCharacterToInt(ch);
            int curValue = romanCharacterToInt(s[i]);
            if(curValue < chValue) {
                num += sum;
                sum = curValue;
                ch = s[i];
            } else {
                num += (curValue - chValue);
                ch = s[i + 1];
                sum = 0;
            }
        }
    }
    if(sum != 0) num += sum;
    return num;
}
