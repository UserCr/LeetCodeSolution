/**
3Sum类水题。
**/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if (null == nums || nums.length < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (0 == i || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (i + 1 == j || nums[j] != nums[j - 1]) {
                        int m = j + 1, n = nums.length - 1;
                        while (m < n) {
                            if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                                while (m < n && nums[m] == nums[m + 1]) m++;
                                m++;
                                while (m < n && nums[n] == nums[n - 1]) n--;
                                n--;
                            } else if (nums[i] + nums[j] + nums[m] + nums[n] > target) {
                                n--;
                            } else {
                                m++;
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
