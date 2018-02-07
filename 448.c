/**
因为题目保证1<=a[i]<=n，所以可以用交换的方法把每一个元素放到它应该待的地方，最后再检查一遍调整过的数组，把应该出现却没有出现的元素全部记录下来就是结果。
以上方案一定要满足1<=a[i]<=n的前提条件，否则可能会碰到死循环。
还有一种思路差不多的方案是将看过的元素乘以-1做标记，最后凡是没有做过标记的，就是缺失的数。
**/

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        for(int i = 0; i < nums.size(); ++i) {
            while(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        vector<int> result;
        for(int i = 0; i < nums.size(); ++i) {
            if(nums[i] != i + 1) result.push_back(i + 1);
        }
        return result;
    }
private:
    void swap(vector<int>& nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};
