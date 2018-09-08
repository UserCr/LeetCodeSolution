//水题。
/**
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
**/

class Solution {
    public int maxDepth(TreeNode root) {
        if(null == root) return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if(null != curNode) {
                if(curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            else {
                height++;
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return height;
    }
}
