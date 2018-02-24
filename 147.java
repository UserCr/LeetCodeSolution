/**
题目是插入排序，十分简单。
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
其实可以用归并排序，速度会快不少。
**/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode fast = head, slow = head, prevSlow = head;
        while (null != fast && null != fast.next) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = null;

        ListNode list1 = insertionSortList(head);
        ListNode list2 = insertionSortList(slow);

        if (null == list1) return list2;
        if (null == list2) return list1;

        ListNode result = null;
        ListNode resultEnd = null;

        while (null != list1 && null != list2) {
            if (list1.val < list2.val) {
                if (null == result) {
                    result = list1;
                    resultEnd = result;
                } else {
                    resultEnd.next = list1;
                    resultEnd = resultEnd.next;
                }
                list1 = list1.next;
            } else {
                if (null == result) {
                    result = list2;
                    resultEnd = result;
                } else {
                    resultEnd.next = list2;
                    resultEnd = resultEnd.next;
                }
                list2 = list2.next;
            }
        }

        if (null != list1) resultEnd.next = list1;
        if (null != list2) resultEnd.next = list2;

        return result;
    }
}
