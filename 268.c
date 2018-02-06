/**
常见思路是求出完整数组的和，再减去所给数组的和，就可以得到缺失的数。该方法可能会溢出，不是很好。
第二种思路是利用xor运算求解。因为a xor a = 0，所以可以将完整数组和所给数组里的所有数都异或一遍，剩下的就是缺失的数。
第三种思路是二分法，需要先对数组进行排序，然后检查中间数，如果中间数比完整数组的中间数大，说明中间数左边缺了一个数，反之就是右边。
如此循环就能找到所缺的数。
因为第三种思路需要排序，时间复杂度至少是O(nlogn)，所以代码实现的是第二种思路。
**/

int missingNumber(int* nums, int numsSize) {
    int result = numsSize;
    for(int i = 0; i < numsSize; i++) {
        result ^= i;
        result ^= nums[i];
    }
    return result;
}
