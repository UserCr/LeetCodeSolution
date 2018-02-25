/**
水题。遍历两次就能得到结果。
**/

class Solution {
    
    private ListNode reverse(ListNode head, int n) {
        ListNode curNode = head, prevNode = null;
        int count = 0;
        while (count < n) {
            ListNode next = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = next;
            count++;
        }
        return prevNode;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (1 == k) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        while (head != null) {
            ListNode reverseEnd = head;
            int count = 0;
            while (count < k && head != null) {
                head = head.next;
                count++;
            }
            if (count < k) {
                prevNode.next = reverseEnd;
            } else {
                prevNode.next = reverse(reverseEnd, k);
                reverseEnd.next = head;
                prevNode = reverseEnd;
            }
        }
        return dummy.next;
    }
}
