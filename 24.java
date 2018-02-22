/**
水题。
**/

class Solution {
    private void swapPair(ListNode before) {
        ListNode first = before.next;
        ListNode second = first.next;
        first.next = second.next;
        second.next = first;
        before.next = second;
    }

    public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next) return head;
        
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head = next;
        
        ListNode before = head.next;
        while(before.next != null && before.next.next != null) {
            swapPair(before);
            before = before.next.next;
        }
        
        return head;
    }
}
