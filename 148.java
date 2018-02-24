/**
归并排序。
自底向上写法：
class Solution {
    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode result = null;
        ListNode resultEnd = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (null == result) {
                    result = l1;
                    resultEnd = l1;
                } else {
                    resultEnd.next = l1;
                    resultEnd = resultEnd.next;
                }
                l1 = l1.next;
            } else {
                if (null == result) {
                    result = l2;
                    resultEnd = l2;
                } else {
                    resultEnd.next = l2;
                    resultEnd = resultEnd.next;
                }
                l2 = l2.next;
            }
        }

        if (null != l1) resultEnd.next = l1;
        if (null != l2) resultEnd.next = l2;

        return result;
    }

    private ListNode findNode(ListNode head, int n) {
        if (null == head) return null;

        for (int i = 1; i < n && head.next != null; ++i) {
            head = head.next;
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        final int length = listLength(head);

        for (int step = 1; step < length; step *= 2) {
            ListNode result = null, resultEnd = null;
            while (null != head) {
                ListNode l1 = head;
                ListNode end = findNode(l1, step);
                ListNode l2 = end.next;
                end.next = null;

                if (null != l2) {
                    end = findNode(l2, step);
                    head = end.next;
                    end.next = null;
                } else {
                    head = null;
                }

                ListNode merge = mergeList(l1, l2);

                if (null == result) {
                    result = merge;
                } else {
                    resultEnd.next = merge;
                }
                resultEnd = findNode(merge, step * 2);
            }
            head = result;
        }
        return head;
    }
}

自顶向下写法：
**/

class Solution {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode fast = head, slow = head, prevSlow = head;
        while (null != fast && null != fast.next) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

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
