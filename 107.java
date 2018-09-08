/**
水题。
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> topOrder = new ArrayList<>();
        if(null == root) return topOrder;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (null != curNode) {
                temp.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            } else {
                topOrder.add(temp);
                temp = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        List<List<Integer>> bottomOrder = new ArrayList<>(topOrder.size());
        for (int i = 0; i < topOrder.size(); i++) {
            bottomOrder.add(topOrder.get(topOrder.size() - i - 1));
        }
        return bottomOrder;
    }
}
