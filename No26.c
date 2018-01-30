/**
一遍遍历找不同并记录，非常简单。
特殊输入，数组长度为0。
**/

int removeDuplicates(int* nums, int numsSize) {
    if(numsSize == 0) return 0;
    int result_end = 0, i = 1;
    while(i < numsSize) {
        if(nums[result_end] != nums[i]) {
            nums[++result_end] = nums[i];
        }
        i++;
    }
    return result_end + 1;
}
