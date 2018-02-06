/**
Solution1:
问题的整体解决思路是先找到下降的点，下降点出现超过一次或是下降点无法修复时返回false，否则为true。
下降点是否能够修复不能只看修复点的一个方向，而要综合两边的数进行判断，下边将三个数可能遇到的所有情况分别进行讨论。
1)132，213，121，212：这几组只要修复中间的数。特征是右边的数大于等于左边的数。
2)?312，?211：这几组在?小于等于中间的数或没有?时，只要修复左边的数。特征是左边和中间的数递减。
3)231?，221?：这几组在?大于等于中间的数或没有?时，只要修复右边的数。特征是右边和中间的数递减。
4)321：无法修复。特征是右边的数比左边的小。
根据以上特征分别判断并修复非法点，可以得到以下算法。

bool checkPossibility(int* nums, int numsSize) {
    if(numsSize <= 2) return true;
    
    bool modified = false;
    for(int i = 1; i < numsSize - 1; i++) {
        if(nums[i - 1] > nums[i] || nums[i] > nums[i + 1]) {
            if(modified) return false;
            if(nums[i + 1] >= nums[i - 1]) {
                nums[i] = nums[i + 1];
            } else if(nums[i - 1] <= nums[i]) {
                if(i + 1 == numsSize - 1 || nums[i + 2] >= nums[i]) {
                    nums[i + 1] = nums[i];
                } else {
                    return false;
                }
            } else if(nums[i] <= nums[i + 1]) {
                if(i - 1 == 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    return false;
                }
            } else {
                return false;
            }
            modified = true;
        }
    }
    return true;
}

Solution2:
以上算法虽然可行，但是需要修改原数组，而且代码行数较多，可以在Solution1的基础上进行改进。
在上述四组数中找到下降点，也就是最后一个上升的数，其位置记为i。观察前三组可修复的数，可以分别得到如下结论：
1)一定可修复，此时i一定满足i + 1 >= i - 1或i <= i + 2
2)i + 1 >= i - 1时可修复。
3)i <= i + 2时可修复。
综上，可得如果i满足i + 1 >= i - 1或i <= i + 2，就一定可以修复，不满足就不能修复。如此可以得到下降点不可修复的简单判断条件，也就是下边的算法。
**/

bool checkPossibility(int* nums, int numsSize) {
    bool modified = false;
    for(int i = 0; i < numsSize - 1; i++) {
        if(nums[i] > nums[i + 1]) {
            if(modified) return false;
            if(i - 1 >= 0 && i + 2 < numsSize && (nums[i - 1] > nums[i + 1] && nums[i] > nums[i + 2])) return false;
            modified = true;
        }
    }
    return true;
}
