/**
水题。
**/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;

        ListNode result = head;

        while (head.next != null) {
            if (head.val == head.next.val) {
                ListNode next = head.next;
                while(next != null && next.val == head.val) next = next.next;
                head.next = next;
            } else {
                head = head.next;
            }
        }

        return result;
    }
}
