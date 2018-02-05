/**
index1向右移动可以增加和，index2向左移动可以减少和，根据和与target的大小关系分别调整两个下标就行。
因为题目说明一定有结果，所以while条件可以直接写成不等，否则可能会出现错误。
**/

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> result;
        int index1 = 0, index2 = numbers.size() - 1;
        while(numbers[index1] + numbers[index2] != target) {
            if(numbers[index1] + numbers[index2] < target) index1++;
            if(numbers[index1] + numbers[index2] > target) index2--;
        }
        
        result.push_back(index1 + 1);
        result.push_back(index2 + 1);
        return result;
    }
};
