/**
水题。
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
    
    public ListNode[] splitListToParts(ListNode root, int k) {
        final int length = listLength(root);
        int remainder = length % k;
        ListNode[] groups = new ListNode[k];
        for (int i = 0; i < k && root != null; i++) {
            groups[i] = root;
            int groupLength = length / k;
            if (remainder > 0) {
                groupLength++;
                remainder--;
            }
            for (int j = 1; j < groupLength && root != null; j++) {
                root = root.next;
            }
            if (null != root) {
                ListNode end = root;
                root = root.next;
                end.next = null;
            }
        }
        return groups;
    }
}
