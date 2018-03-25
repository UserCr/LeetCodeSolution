/**
二分水题。
**/

int search(int* nums, int numsSize, int target) {
    for(int left = 0, right = numsSize - 1; left <= right;) {
        int mid = (left + right) / 2;
        
        if(nums[mid] < target) {
            if(nums[right] < nums[mid] || nums[right] > target) {
                left = mid + 1;
            } else if(nums[right] < target) {
                right = mid - 1;
            } else {
                return right;
            }
        } else if(nums[mid] > target) {
            if(nums[left] > nums[mid] || nums[left] < target) {
                right = mid - 1;
            } else if(nums[left] > target) {
                left = mid + 1;
            } else {
                return left;
            }
        } else {
            return mid;
        }
    }
    
    return -1;
}
