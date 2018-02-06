/**
用hashmap存储元素的下标，遇到同样的元素时只需判断是否下标的差和k的大小关系。
这个题目不能排序解决。
**/

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        map<int, int> hashmap;
        map<int, int>::iterator it;
        for(int i = 0; i < nums.size(); ++i) {
            it = hashmap.find(nums[i]);
            if(it != hashmap.end() && (i - (it -> second) <= k)) {
                return true;
            }
            hashmap[nums[i]] = i;
        }
        return false;
    }
};
