/**
本题实际是求出数组中以频数最大的数为首尾的字串的长度。一次遍历记下每个元素的频数和首尾位置，然后再遍历中间结果求解。
特殊输入：数组中可能会有多个频数一样的数。
**/

class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        map<int, Node*> hmap;
        int max_frequency = 0;
        Node* node = NULL;
        for(int i = 0; i < nums.size(); ++i) {
            node = hmap[nums[i]];
            if(NULL == node) {
                node = (Node*)malloc(sizeof(Node));
                node -> frequency = 1;
                node -> first_index = node -> last_index = i;
                hmap[nums[i]] = node;
            } else {
                node -> frequency += 1;
                node -> last_index = i;
            }
            if(max_frequency < node -> frequency) max_frequency = node -> frequency;
        }
        
        int shortest_length = 50001;
        for(map<int, Node*>::iterator iterator = hmap.begin(); iterator != hmap.end(); iterator++) {
            if(NULL != iterator -> second && max_frequency == iterator -> second -> frequency && 
               shortest_length > iterator -> second -> last_index - iterator -> second -> first_index + 1) {
                shortest_length = iterator -> second -> last_index - iterator -> second -> first_index + 1;
            }
            free(iterator -> second);
        }
        
        return shortest_length;
    }
private:
    class Node {
        public:
        int frequency;
        int first_index;
        int last_index;
    };
};
