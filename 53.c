/**
Solution1:
O(n)算法核心思想是将最大和子串分成左子串和右子串两个部分，一旦左子串和为负，就意味着该左子串对于总体和的贡献为负，需要将其从最大和子串中剔除。
以下算法如果没有调整sum = 0的部分，就是求出以0为左端的最大和子串的和。sum = 0作用是剔除为和负的左子串，将其加入整体算法后就可以求出最大和子串的和了。
int maxSubArray(int* nums, int numsSize) {
    int sum = 0, max_sum = INT_MIN;
    for(int i = 0; i < numsSize; ++i) {
        sum += nums[i];
        if(sum > max_sum) {
            max_sum = sum;
        }
        if(sum < 0) {
            sum = 0;
        }
    }
    return max_sum;
}

Solution2:
分治算法核心思想也是将最大和子串看成左子串和右子串两个部分。对于某一个串来说，它的最大和字串可能是左子串的一部分，也可能是右子串的一部分，
还可能是左字串靠右的部分加上右子串靠左的部分拼接而成。所以要想求出一个串的最大和子串，就要先求出左子串的最大和子串，右子串的最大和子串，
左子串靠右的最大和子串，右子串靠左的最大和子串这四个前提解。对于该串的左子串和右子串，再分别求出其四个前提解，如此反复，
就可以递归求出最大和子串了。
递归的返回条件是当串只有一个数时，四个前提解当然就是串本身。
**/

typedef struct SubArray {
    int left_max;
    int right_max;
    int max;
    int sum;
} SubArray;

int max(int i, int j) {
    return i >= j ? i : j;
}

SubArray* findSubArray(int* nums, int i, int j) {
    SubArray* result = (SubArray*)malloc(sizeof(SubArray));
    if(i == j) {
        result -> max = result -> sum = result -> left_max = result -> right_max = nums[i];
    } else {
        SubArray* left_array = findSubArray(nums, i, (i + j) / 2);
        SubArray* right_array = findSubArray(nums, (i + j) / 2 + 1, j);
        result -> left_max = max(left_array -> left_max, left_array -> sum + right_array -> left_max);
        result -> right_max = max(right_array -> right_max, right_array -> sum + left_array -> right_max);
        result -> max = max(max(left_array -> max, right_array -> max), left_array -> right_max + right_array -> left_max);
        result -> sum = left_array -> sum + right_array -> sum;
        free(left_array);
        free(right_array);
    }
    return result;
}

int maxSubArray(int* nums, int numsSize) {
    SubArray* result = findSubArray(nums, 0, numsSize - 1);
    int max = result -> max;
    free(result);
    return max;
}
