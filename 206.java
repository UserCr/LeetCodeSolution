/**
水题。
**/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null, curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        return prevNode;
    }
}
