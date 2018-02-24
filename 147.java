/**
插入排序，水题。
**/

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (null == head) return null;

        ListNode result = head;
        head = head.next;
        result.next = null;

        while (head != null) {
            if (head.val < result.val) {
                ListNode next = head.next;
                head.next = result;
                result = head;
                head = next;
            } else {
                ListNode before = result;
                while (before.next != null && before.next.val < head.val) before = before.next;
                ListNode next = before.next;
                before.next = head;
                head = head.next;
                before.next.next = next;
            }
        }

        return result;
    }
}
