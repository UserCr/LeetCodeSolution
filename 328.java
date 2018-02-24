/**
水题。
除代码所示的方法外，分别将偶数奇数连接后再将偶数链连接在奇数链后边也是可行的，时间效率都是O(n)。
**/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode insert = head, scan = head.next;
        while (null != scan && null != scan.next) {
            ListNode next = scan.next.next;
            scan.next.next = insert.next;
            insert.next = scan.next;
            scan.next = next;
            insert = insert.next;
            scan = scan.next;
        }
        return head;
    }
}
