/**
水题。
**/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode prevNode = l1.val <= l2.val ? l1 : l2;
        ListNode resultNode = prevNode;
        ListNode curNode = prevNode.next;
        ListNode anotherListNode = l1.val <= l2.val ? l2 : l1;
        while (curNode != null && anotherListNode != null) {
            if (curNode.val <= anotherListNode.val) {
                prevNode = curNode;
                curNode = curNode.next;
            } else {
                prevNode.next = anotherListNode;
                anotherListNode = anotherListNode.next;
                prevNode.next.next = curNode;
                prevNode = prevNode.next;
            }
        }
        if(anotherListNode != null) prevNode.next = anotherListNode;
        
        return resultNode;
    }
}
