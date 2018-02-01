/**
常见思路是从头遍历，时间复杂度是O(n)。
可以用二分法快速找到所在位置，找不到时只需将左下标向右遍历即可。
特殊输入是数组长度为0或1，或是目标值不在数组中。
**/

int searchInsert(int* nums, int numsSize, int target) {
    int left = 0, right = numsSize - 1;
    int mid;
    while(left < right) {
        mid = (left + right) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    while(left < numsSize && nums[left] < target) left++;
    
    return left;
}
