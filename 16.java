/**
3Sum类水题。不要优化，否则可能会错过某些数。
**/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;

        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            if (0 == i || nums[i] != nums[i - 1]) {
                int m = i + 1, n = nums.length - 1;
                while (m < n) {
                    if (m < n && Math.abs(nums[i] + nums[m] + nums[n] - target) < Math.abs(sum - target)) {
                        sum = nums[i] + nums[m] + nums[n];
                    }
                    if (m < n && nums[i] + nums[m] + nums[n] < target) {
                        m++;
                    } else if (m < n && nums[i] + nums[m] + nums[n] > target) {
                        n--;
                    } else if (m < n) {
                        return target;
                    }
                }
            }
        }

        return sum;
    }
}
