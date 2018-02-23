/**
分治递归做就是水题，代码部分记录的是递归代码。
非递归方法类似于数组建树，麻烦在于链表遍历时不可随机访问的特性，因此不能直接套用数组下标二分取值的办法，而需要用一个队列保存上层的节点位置，
然后根据上层的的节点位置二分法计算出本层的节点位置，找到它们并链接到树中。这是一种基于二分性质自顶向下的建树方法，时间O(nlogn)，空间O(n)。
非递归代码用了很多Java容器，速度反而慢了不少。代码如下：
class Solution {
    
    class Pair {
        TreeNode treeNode;
        int index;
        boolean Null;

        Pair(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
            this.Null = false;
        }

        Pair() {
            this.Null = true;
        }

        boolean isNull() {
            return this.Null;
        }
    }
    
    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    private ListNode findNode(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int length = listLength(head);
        if (0 == length) return null;

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[length];

        ListNode curNode = head;
        for (int i = 0; i < length / 2; i++) {
            curNode = curNode.next;
        }
        TreeNode root = new TreeNode(curNode.val);
        queue.add(new Pair(root, length / 2));
        visited[length / 2] = true;
        queue.add(new Pair());

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            while (!pair.isNull()) {
                int left = pair.index - 1 >= 0 ? pair.index - 1 : 0;
                if (!visited[left]) {
                    while (left >= 0 && !visited[left]) left--;
                    left++;
                    left = (left + pair.index - 1) / 2;
                    ListNode node = findNode(head, left);
                    pair.treeNode.left = new TreeNode(node.val);
                    visited[left] = true;
                    queue.add(new Pair(pair.treeNode.left, left));
                }
                int right = pair.index + 1 < length ? pair.index + 1 : length - 1;
                if (!visited[right]) {
                    while (right < length && !visited[right]) right++;
                    right--;
                    right = (right + pair.index + 1) / 2;
                    ListNode node = findNode(head, right);
                    pair.treeNode.right = new TreeNode(node.val);
                    visited[right] = true;
                    queue.add(new Pair(pair.treeNode.right, right));
                }
                pair = queue.poll();
            }
            if (!queue.isEmpty()) queue.add(new Pair());
        }
        return root;
    }
}
**/

class Solution {
    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private TreeNode sortedListToBST(ListNode head, int length) {
        if (null == head || 0 == length) return null;

        if (1 == length) return new TreeNode(head.val);

        TreeNode leftTree = sortedListToBST(head, length / 2);
        for (int i = 0; i < length / 2; i++) {
            head = head.next;
        }
        TreeNode root = new TreeNode(head.val);
        TreeNode rightTree = sortedListToBST(head.next, length / 2 - ((length + 1) % 2));
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int length = listLength(head);
        return sortedListToBST(head, length);
    }
}

