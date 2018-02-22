/**
要注意不能把反转链表的代码简单套用过来，要考虑到把需要反转的部分反转以后，还需要链接其他部分。
1->2->3->4->5->NULL，反转3和4，正确答案是1->2->4->3->5->NULL，如果只是简单套用的话，结果会变成1->2<->3<-4 5->NULL。
**/

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head || null == head.next || m == n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy, curNode = head;
        int position = 1;
        while (position < m) {
            prevNode = curNode;
            curNode = curNode.next;
            position++;
        }
        ListNode frontEnd = prevNode, reserveEnd = curNode;
        while (position <= n) {
            ListNode next = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = next;
            position++;
        }

        frontEnd.next = prevNode;
        reserveEnd.next = curNode;

        return dummy.next;
    }
}
