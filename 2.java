/**
水题。
**/

class Solution {
    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode sumList = listLength(l1) >= listLength(l2) ? l1 : l2;
        ListNode result = sumList;
        ListNode addend = sumList == l1 ? l2 : l1;

        int add = 0;
        while (addend != null) {
            int sum = sumList.val + addend.val + add;
            sumList.val = sum % 10;
            add = sum / 10;

            sumList = sumList.next;
            addend = addend.next;
        }

        while (sumList != null && add != 0) {
            int sum = sumList.val + add;
            sumList.val = sum % 10;
            add = sum / 10;
            sumList = sumList.next;
        }

        if (add != 0) {
            ListNode end = result;
            while (end.next != null) end = end.next;
            end.next = new ListNode(1);
        }

        return result;
    }
}
