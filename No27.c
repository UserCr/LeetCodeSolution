/**
Solution1:
int removeElement(int* nums, int numsSize, int val) {
    int result_end = -1;
    for(int i = 0; i < numsSize; ++i) {
        if(nums[i] != val) nums[++result_end] = nums[i];
    }
    return result_end + 1;
}
这个方案需要多遍历一些元素，需要改进，改进方案如下。
**/

int removeElement(int* nums, int numsSize, int val) {
    for(int i = 0; i < numsSize; ++i) {
        while(nums[numsSize - 1] == val && numsSize > 0) numsSize--; //从尾端找到第一个不为val的元素并抛弃掉为val的元素
        if(nums[i] == val && i < numsSize) {
            nums[i] = nums[--numsSize]; //从首端找到第一个为val的元素并与最尾端元素交换，交换后的尾端元素直接抛弃
        }
    }
    return numsSize;
}
