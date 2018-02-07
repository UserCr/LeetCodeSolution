/**
复习快速排序的水题。
因为题目中i的范围比较小，所以桶式排序会快一些。
如果i范围非常大，数组长度又非常小时，快速排序更合适。
**/

int partition(int* nums, int i, int j) {
    int pivot = nums[i];
    while(i < j) {
        while(nums[j] >= pivot && j > i) j--;
        nums[i] = nums[j];
        while(nums[i] <= pivot && j > i) i++;
        nums[j] = nums[i];
    }
    nums[i] = pivot;
    return i;
}

void sort(int* nums, int i, int j) {
    if(i >= j) return;
    
    int mid = partition(nums, i, j);
    sort(nums, i, mid - 1);
    sort(nums, mid + 1, j);
}

int arrayPairSum(int* nums, int numsSize) {
    sort(nums, 0, numsSize - 1);
    int sum = 0;
    for(int i = 0; i < numsSize; i += 2) {
        sum += nums[i];
    }
    return sum;
}
