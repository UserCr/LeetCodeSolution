/**
水题。
找链表中点的时候用两个指针比根据长度求中点快一点，可以少遍历一遍
**/

class Solution {
    
    private ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode prevNode = null, curNode = head;
        while (null != curNode) {
            ListNode next = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = next;
        }

        return prevNode;
    }

    public void reorderList(ListNode head) {
        if (null == head || null == head.next) return;

        ListNode fast = head, slow = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode insertHead = reverseList(slow.next);
        slow.next = null;

        while (insertHead != null) {
            ListNode originNext = head.next;
            ListNode insertNext = insertHead.next;
            head.next = insertHead;
            insertHead.next = originNext;
            head = originNext;
            insertHead = insertNext;
        }
    }
}
