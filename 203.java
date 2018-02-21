/**
水题。
**/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result;
        while (head != null && head.val == val) {
            head = head.next;
        }
        result = head;

        for (ListNode currentNode = result; currentNode != null; currentNode = currentNode.next) {
            ListNode nextNode = currentNode.next;
            while (nextNode != null && nextNode.val == val) {
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
        }
        
        return result;
    }
}
