/**
3Sum问题。一个常见思路是先排序，然后固定一个数，另外两个指针从剩下的数里分别向中间移动，从而求解。
这个题目需要额外注意的是去重问题，只要遵循先记录解，再略过重复元素的思路就没有问题，否则可能会少解。
**/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (0 == i || nums[i] != nums[i - 1]) {
                int m = i + 1, n = nums.length - 1;
                while (m < n) {
                    if (nums[m] + nums[n] + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[m], nums[n]));
                        while (m < n && nums[n - 1] == nums[n]) n--;
                        n--;
                        while (m < n && nums[m + 1] == nums[m]) m++;
                        m++;
                    } else if (nums[m] + nums[n] + nums[i] < 0) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }

        return result;
    }
}
