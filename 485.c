/**
水题。
**/
int findMaxConsecutiveOnes(int* nums, int numsSize) {
    int max_count = 0, count = 0;
    for(int i = 0; i < numsSize; ++i) {
        if(1 == nums[i]) {
            count++;
            if(count > max_count) max_count = count;
        } else {
            count = 0;
        }
    }
    return max_count;
}
