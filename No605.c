/**
数连续0的个数，从而判断出i-1能否种植，继而求出最大种植数。zero_count是最近的一个1之后连续输入的0的个数，如果前一位可种植，就把那一位当1处理。
数组的-1位和最后一位的后一位不会产生影响，因此按0处理。
**/
bool canPlaceFlowers(int* flowerbed, int flowerbedSize, int n) {
    int usable_count = 0, zero_count = 1; 
    for(int i = 0; i <= flowerbedSize; ++i) {
        if(0 == flowerbed[i] || i == flowerbedSize) {
            zero_count++;
            if(4 == zero_count) zero_count = 2;
            else if(3 == zero_count) usable_count++;
        } else {
            zero_count = 0;
        }
    }
    return usable_count >= n;
}
