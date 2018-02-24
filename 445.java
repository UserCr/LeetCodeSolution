/**
题目要求不许反转链表，好像除了用O(n)空间辅助外没有什么特别好的办法，这里用的是栈，实际用数组也行。
**/

class Solution {
    
    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        
        final int length1 = listLength(l1);
        final int length2 = listLength(l2);

        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode result = length1 > length2 ? l1 : l2;
        ListNode sum = result;
        ListNode add = length1 > length2 ? l2 : l1;
        for (int i = 0; i < Math.abs(length1 - length2); i++) {
            stack.push(sum);
            sum = sum.next;
        }
        while (sum != null) {
            sum.val += add.val;
            stack.push(sum);
            sum = sum.next;
            add = add.next;
        }
        int number = 0;
        while (!stack.isEmpty()) {
            int value = stack.peek().val + number;
            stack.peek().val = value % 10;
            number = value / 10;
            stack.pop();
        }
        if (number == 1) {
            ListNode first = new ListNode(1);
            first.next = result;
            result = first;
        }
        return result;
    }
}
