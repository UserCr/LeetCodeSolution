/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

class Solution {
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
}
*/

//实际就是判断二叉树中序遍历是否回文，一个指针做中序遍历，另一个指针做相反的操作即可。
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        TreeNode leftPointer = root, rightPointer = root;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        while((!leftStack.isEmpty() || leftPointer != null) && (!rightStack.isEmpty() || rightPointer != null)) {
            while(leftPointer != null && rightPointer != null) {
                leftStack.push(leftPointer);
                leftPointer = leftPointer.left;
                rightStack.push(rightPointer);
                rightPointer = rightPointer.right;
            }
            if(leftPointer != null || rightPointer != null) {
                return false;
            }
            leftPointer = leftStack.pop();
            rightPointer = rightStack.pop();
            if(leftPointer.val != rightPointer.val) {
                return false;
            }
            leftPointer = leftPointer.right;
            rightPointer = rightPointer.left;
        }
        return true;
    }
}
