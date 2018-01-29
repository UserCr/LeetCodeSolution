/*
经典解法是重新申请一个临时数组，两个数组从头到尾依次比大小放进临时数组里。
这道题要求是把结果放进第一个数组里，所以要做一点小改动，可以把题目理解成把nums2里的数放进nums1里。
因此把第一个数组当成结果数组，从后往前装依次比较大小放结果就行。如果最后nums2还有剩余，直接拷贝进nums1就可以了。
这样可以避免经典解法中把临时数组拷贝到nums1的时间。
*/
void merge(int* nums1, int m, int* nums2, int n) {
    int nums1_index = m - 1, nums2_index = n - 1, result_index = m + n - 1;
    while(nums1_index >= 0 && nums2_index >= 0) {
        nums1[result_index--] = nums1[nums1_index] > nums2[nums2_index] ? nums1[nums1_index--] : nums2[nums2_index--]; 
    }
    while(nums2_index >= 0) {
        nums1[result_index--] = nums2[nums2_index--];
    }
    return;
}
