/**
因为题目要求前三大的数不能重复，所以只简单记录三个变量并替换的算法就不再适用了，需要做一些修改。
只在条件完全符合时更新变量，同时维护三变量是否有效的辅助数组，就可以正确求解。
测试用例中会遇到{INT_MIN, INT_MIN + 1, INT_MIN + 2}这种边界测试，因此用C求解时不要用INT_MIN之类的特殊值表示某变量无效，
不然还要针对边界输入做特殊处理，平添麻烦。
另外Java中可以用null表示无效，所以Java求解会方便许多。
**/

int thirdMax(int* nums, int numsSize) {
    bool max_valid[3] = {false, false, false};
    int max_first, max_second, max_third;
    for(int i = 0; i < numsSize; ++i) {
        if(!max_valid[0]) {
            max_first = nums[i];
            max_valid[0] = true;
        } else if(nums[i] > max_first) {
            max_third = max_second;
            if(max_valid[1]) max_valid[2] = true;
            max_second = max_first;
            max_valid[1] = true;
            max_first = nums[i];
        } else if(nums[i] != max_first && !max_valid[1]) {
            max_second = nums[i];
            max_valid[1] = true;
        } else if(nums[i] != max_first && max_valid[1] && nums[i] > max_second) {
            max_third = max_second;
            max_valid[2] = true;
            max_second = nums[i];
        } else if(nums[i] != max_first && nums[i] != max_second && !max_valid[2]) {
            max_third = nums[i];
            max_valid[2] = true;
        } else if(nums[i] != max_first && nums[i] != max_second && max_valid[2] && nums[i] > max_third) {
            max_third = nums[i];
            max_valid[2] = true;
        }
    }
    
    if(max_valid[2]) return max_third;
    
    return max_first;
}
