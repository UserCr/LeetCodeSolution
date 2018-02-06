/**
比较常见的思路是再开一个数组，把最后k个数存进去，把原数组调整好后再将这k个数放到对应的位置。
还有一种思路是将原数组反转，再把前k个数和后numsSize-k个数分别反转。
以上两种思路都比较简单，下边主要记录一趟遍历，O(1)空间的思路。
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
