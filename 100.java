/**
水题。复习一下二叉树先序遍历的非递归写法。
**/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        } else if (null == p || null == q) {
            return false;
        }

        LinkedList<TreeNode> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
        TreeNode currentNode1 = p, currentNode2 = q;
        while ((!stack1.isEmpty() || null != currentNode1) && (!stack2.isEmpty() || null != currentNode2)) {
            while (null != currentNode1 || null != currentNode2) {
                if (null == currentNode1 || null == currentNode2) return false;
                if (currentNode1.val != currentNode2.val) return false;

                stack1.push(currentNode1);
                stack2.push(currentNode2);
            }
            if (!stack1.isEmpty()) {
                currentNode1 = stack1.getFirst().right;
                stack1.removeFirst();
            }
            if (!stack2.isEmpty()) {
                currentNode2 = stack2.getFirst().right;
                stack2.removeFirst();
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
