/**
水题。注意考虑到n为链表长度时的特殊情形。
**/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;

        ListNode toEnd = head;
        for (int i = 0; i < n; ++i) {
            toEnd = toEnd.next;
        }

        if (null == toEnd) {
            head = head.next;
        } else {
            ListNode toDeleteFront = head;
            while (null != toEnd.next) {
                toDeleteFront = toDeleteFront.next;
                toEnd = toEnd.next;
            }
            toDeleteFront.next = toDeleteFront.next.next;
        }
        
        return head;
    }
}
