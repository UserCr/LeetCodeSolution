/**
整体思路就是维护一个队列，凡是遇到比x小的节点，就把它置于队尾，凡是遇到大于等于x的节点就将其入队。当把所有节点都检查一遍后，就是所求结果。
特殊输入是空链，只有一个节点的链，所有节点都大于等于x或所有节点都小于x的链。
**/

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (null == head || null == head.next) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode fast = head;
        while (fast.next != null && !(fast.val >= x && fast.next.val < x)) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (slow.next != null && !(slow.val < x && slow.next.val >= x)) {
            slow = slow.next;
        }

        while (fast.next != null) {
            if (fast.next.val >= x) {
                fast = fast.next;
            } else {
                ListNode move = fast.next;
                fast.next = move.next;
                move.next = slow.next;
                slow.next = move;
                slow = move;
            }
        }

        return dummy.next;
    }
}
