/**
思路和两指针判断链表是否有环相似。假设链表有环，非环部分长s1，两指针相遇时slow在环中走的距离为s2，fast在环中一定走过一部分slow没走过的节点，距离记为s3，
显然相遇时fast走过的距离是s1+s2+s3+s2，slow走过的距离是s1+s2，又因为fast走过的距离是slow的两倍，所以s1=s3。只要让head和fast分别一步一步走，
相遇处就是所求节点。
**/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (null == head) return null;

        ListNode fast = head, slow = head;

        do {
            if (null == fast.next || null == fast.next.next) return null;

            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }

        return head;
    }
}
