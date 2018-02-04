/**
先分别找到发生降序的左右位置，分别记作i和j，可以认为该子数组是乱序的，其中的最大值可能大于j+1，最小值可能小于i-1，所以还需要扩大子数组长度直到满足条件。
**/

int findUnsortedSubarray(int* nums, int numsSize) {
    int start = 0, end = numsSize - 1;
    while(nums[start] <= nums[start + 1] && start < numsSize - 1) start++;
    while(nums[end - 1] <= nums[end] && end > 0) end--;
    
    if(start >= end) return 0;
    
    int max = nums[start], min = nums[start];
    for(int i = start; i <= end; ++i) {
        if(nums[i] > max) max = nums[i];
        if(nums[i] < min) min = nums[i];
    }
    while(nums[start - 1] > min && start > 0) start--;
    while(nums[end + 1] < max && end < numsSize - 1) end++;
    
    return end - start + 1;
}
