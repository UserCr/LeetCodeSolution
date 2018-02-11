/**
水题。二叉树后序遍历求解。
**/

class Solution {    
    public String tree2str(TreeNode t) {
        StringBuilder stringBuilder = new StringBuilder();
        if(null == t) {
            return "";
        } else if(null == t.left && null == t.right) {
            stringBuilder.append(t.val);
        } else {
            String left = tree2str(t.left);
            stringBuilder.append(t.val).append('(').append(left).append(')');
            String right = tree2str(t.right);
            if(right.length() > 0) stringBuilder.append('(').append(right).append(')');
        }
        return stringBuilder.toString();
    }
}
