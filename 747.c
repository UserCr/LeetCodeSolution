/**
题目等价于找出数组中最大的前两个数，再判断最大的数是不是大于等于第二大的数的两倍。
常见思路是遍历两遍找到这两个数，下边的思路遍历一遍就可以。
找最大的数非常简单，找第二大的数分为两种情况，一种情况是当前的数是最大值，那么之前的最大数自然变成第二大的数，第二种情况是当前的数小于最大值，
但是比之前的第二大的数大，那么第二大的数就会变成当前的数。
两种特殊输入是数组大小为0或为1。
**/

int dominantIndex(int* nums, int numsSize) {
    if(0 == numsSize) return -1;
    if(1 == numsSize) return 0;
    int max_index = 0, second_max_value = 0;
    for(int i = 1; i < numsSize; ++i) {
        if(nums[max_index] < nums[i]) {
            second_max_value = nums[max_index];
            max_index = i;
        } else if(second_max_value < nums[i] && nums[i] < nums[max_index]) {
            second_max_value = nums[i];
        }
    }
    if(nums[max_index] >= second_max_value * 2) return max_index;
    return -1;
}
