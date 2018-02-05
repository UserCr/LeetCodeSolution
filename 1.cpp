/** 常见思路是暴力方法。快一些的方法是用hashtable存储读过的数据的差值，然后O(1)查找新的数在不在hashtable中即可。
因为leetcode上的测试用例好像数值都不是很大，所以C的hash function可以简单实现成f(n)=n。
**/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> another_nums;
        for(int i = 0; i < nums.size(); ++i) {
            if(another_nums.count(nums[i]) == 0) {
                another_nums[target - nums[i]] = i;
            } else {
                vector<int> result;
                result.push_back(another_nums[nums[i]]);
                result.push_back(i);
                return result;
            }
        }
    }
};
