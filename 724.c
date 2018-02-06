/**
显然暴力算法会将前若干个数和后若干个数重复求和若干次，因此要通过记录之前的计算结果来避免重复计算。
因为第一遍遍历时无法知道后续的数，即使将中间结果记录下来，最后也需要遍历一遍中间结果才可能找到解，所以只遍历一次是无法求解的，
想要求解至少需要遍历两次。
特殊输入是数组长度为0。
**/

int pivotIndex(int* nums, int numsSize) {
    if(0 == numsSize) return -1;
    int right_sum = 0;
    for(int i = 1; i < numsSize; ++i) {
        right_sum += nums[i];
    }
    if(0 == right_sum) return 0;
    int left_sum = 0;
    for(int i = 1; i < numsSize; ++i) {
        left_sum += nums[i - 1];
        right_sum -= nums[i];
        if(left_sum == right_sum) return i;
    }
    return -1;
}
