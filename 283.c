/**
水题。
**/

void moveZeroes(int* nums, int numsSize) {
    int zero_count = 0, write_index = 0;
    for(int i = 0; i < numsSize; ++i) {
        if(0 == nums[i]) {
            zero_count++;
        } else {
            nums[write_index++] = nums[i];
        }
    }
    while(write_index < numsSize) {
        nums[write_index++] = 0;
    }
}
