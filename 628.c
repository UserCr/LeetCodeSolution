/**
数组中有负数，可能最大乘积可能由两负一正相乘得到，所以问题等价于找数组中最大的三个数和最小的两个数。
**/

int maximumProduct(int* nums, int numsSize) {
    //将前三个数分别赋值给对应的变量。
    int max_first, max_second, max_third;
    max_first = max_third = nums[0];
    for(int i = 0; i < 3; i++) {
        if(nums[i] > max_first) max_first = nums[i];
        if(nums[i] < max_third) max_third = nums[i];
    }
    max_second = nums[0] + nums[1] + nums[2] - max_first - max_third;
    int min_first = max_third, min_second = max_second;
    
    for(int i = 3; i < numsSize; ++i) {
        if(nums[i] > max_first) {
            max_third = max_second;
            max_second = max_first;
            max_first = nums[i];
        } else if(nums[i] > max_second) {
            max_third = max_second;
            max_second = nums[i];
        } else if(nums[i] > max_third) {
            max_third = nums[i];
        }
        if(nums[i] < min_first) {
            min_second = min_first;
            min_first = nums[i];
        } else if(nums[i] < min_second) {
            min_second = nums[i];
        }
    }
    int factor = (max_second * max_third) > (min_first * min_second) ? (max_second * max_third) : (min_first * min_second);
    return factor * max_first;
}
