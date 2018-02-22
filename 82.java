/**
水题。注意可能会存在1112223或111222这种特殊输入。
**/

class Solution {
    private ListNode deleteDuplicateHead(ListNode head) {
        while (null != head && null != head.next && head.val == head.next.val) {
            int headValue = head.val;
            while (null != head && head.val == headValue) {
                head = head.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        head = deleteDuplicateHead(head);

        if (null == head || null == head.next) return head;

        for (ListNode before = head; before != null && before.next != null; before = before.next) {
            before.next = deleteDuplicateHead(before.next);
        }

        return head;
    }
}
