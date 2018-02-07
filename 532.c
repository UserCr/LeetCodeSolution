/**
从小到大排序后检查i后边是否有i+k也可以。因为i增加后，其对应的i+k一定比原来的i+k大，所以可以用两个下标分别向右移动以省去不必要的重复。
注意特殊输入k < 0时，要返回0。
**/

class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        if(k < 0) return 0;
        
        map<int, int> m;
        for(int i = 0; i < nums.size(); ++i) {
            if(m.find(nums[i]) != m.end()) {
                m[nums[i]] += 1;
            } else {
                m[nums[i]] = 1;
            }
        }
        
        int count = 0;
        map<int, int>::iterator it = m.begin();
        if(0 == k) {
            while(it != m.end()) {
                if(it -> second > 1) count++;
                it++;
            }
        } else if(k > 0) {
            while(it != m.end()) {
                if(m.find(it -> first + k) != m.end()) count++;
                if(m.find(it -> first - k) != m.end()) count++;
                it++;
            }
            count /= 2;
        }
        return count;
    }
};
