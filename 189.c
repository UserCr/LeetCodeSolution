/**
从后往前，每次移动k个数，直到数组头部剩k个数没有移动，这时前k个数中全部都是原数组的最后k位，但是顺序是错误的，有前numsSize % k个数被放到了前边，
需要再次调整位置。这时问题就变成了对这k个数做k - numsSize % k步的旋转。
以下是方便理解的递归代码，因为是尾递归，可以改成循环提高效率。
void rotate(int* nums, int numsSize, int k) {
    k %= numsSize;
    if(0 == numsSize || 0 == k) return;
    
    for(int i = numsSize - 1; i >= k; i--) {
        swap(nums, i, i - k);
    }
    rotate(nums, k, k - numsSize % k);
}
**/

void swap(int *nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

void rotate(int* nums, int numsSize, int k) {    
    if(0 == numsSize) return;
    
    k %= numsSize;
    
    while(k % numsSize != 0) {
        for(int i = numsSize - 1; i >= k; i--) {
            swap(nums, i, i - k);
        }
        int oldNumsSize = numsSize;
        numsSize = k;
        k -= (oldNumsSize % k);
    }
}
