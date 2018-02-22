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

    public ListNode rotateRight(ListNode head, int k) {
        final int length = listLength(head);
        if (0 == length || k % length == 0) return head;

        ListNode toEnd = head;
        for (int i = 0; i < k % length; i++) {
            toEnd = toEnd.next;
        }

        ListNode newEnd = head;
        while (toEnd.next != null) {
            newEnd = newEnd.next;
            toEnd = toEnd.next;
        }
        toEnd.next = head;
        ListNode newHead = newEnd.next;
        newEnd.next = null;
        
        return newHead;
    }
}
