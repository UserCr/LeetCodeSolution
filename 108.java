//水题。

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        TreeNode root = null;
        if(left <= right) {
            int mid = (left + right) / 2;
            root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, left, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, right);
        }
        return root;
    }
}
