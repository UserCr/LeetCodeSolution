/**
水题。题意是用数组中的数字排序，找到比给定顺序大的下一个序列。
**/

void swap(int * nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

void reverse(int* nums, int i, int j) {
    while(i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
}

void nextPermutation(int* nums, int numsSize) {
    if(numsSize <= 1) return;
    
    int i = numsSize - 1, swap_index = numsSize - 1;
    for(; i > 0; --i) {
        if(nums[i - 1] < nums[i]) {
            int swap_index = numsSize - 1;
            
            while(swap_index > i && nums[swap_index] <= nums[i - 1]) swap_index--;       
            
            swap(nums, i - 1, swap_index);
            break;
        }
    }
    
    reverse(nums, i, numsSize - 1);
}
