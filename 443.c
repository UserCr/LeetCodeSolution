/**
水题。注意循环结束的时候要再更新一次。
**/

int write_compress_char(char* s, int write, char cur_char, int count) {
    if(1 == count) {
        s[write] = cur_char;
        return 1;
    }
    
    int write_count = 0;
    while(count != 0) {
        s[write--] = (count % 10) + '0';
        count /= 10;
        write_count++;
    }
    s[write] = cur_char;
    write_count++;
    
    return write_count;
}


int compress(char* chars, int charsSize) {
    if(1 == charsSize) return charsSize;
    
    char cur_char = chars[charsSize - 1];
    int count = 1, write_index = charsSize - 1;
    for(int i = charsSize - 2; i >= 0; --i) {
        if(cur_char != chars[i]) {
            write_index -= write_compress_char(chars, write_index, cur_char, count);
            count = 1;
            cur_char = chars[i];
        } else {
            count++;
        }
    }
    write_index -= write_compress_char(chars, write_index, cur_char, count);
    
    int i = 0;
    write_index++;
    while(write_index < charsSize) {
        chars[i++] = chars[write_index++];
    }
    
    return i;
}
