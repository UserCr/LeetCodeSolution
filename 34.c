/**
二分水题。
**/

int binarySearch(int* nums, int left, int right, int target) {
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] < target) {
            left = mid + 1;
        } else if(nums[mid] > target) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}

int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
    *returnSize = 2;
    int* result = malloc(sizeof(int) * 2);
    result[0] = result[1] = -1;
    
    int index = binarySearch(nums, 0, numsSize - 1, target);
    if(-1 == index) return result;
    
    while(index != 0 && nums[index - 1] == target) {
        index = binarySearch(nums, 0, index - 1, target);
    }
    result[0] = index;
    
    while(index != numsSize - 1 && nums[index + 1] == target) {
        index = binarySearch(nums, index + 1, numsSize - 1, target);
    }
    result[1] = index;
    
    return result;
}
