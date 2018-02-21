/**
O(n)时间，O(1)空间至少要遍历两遍，第一遍知道链的长度，第二遍把一半链反转，然后再逐个检查。
**/

class Solution {
    class Pair {
        ListNode first;
        ListNode second;

        Pair(ListNode first, ListNode second) {
            this.first = first;
            this.second = second;
        }
    }

    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    private Pair divideListFromMiddle(ListNode head) {
        final int length = listLength(head);
        ListNode prevNode = null, curNode = head;
        for (int count = 0; count < length / 2; ++count) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        if (length % 2 == 0) {
            return new Pair(curNode, prevNode);
        } else {
            return new Pair(curNode.next, prevNode);
        }
    }

    public boolean isPalindrome(ListNode head) {
        Pair pair = divideListFromMiddle(head);
        for (ListNode left = pair.first, right = pair.second; left != null && right != null; left = left.next, right = right.next) {
            if (left.val != right.val) return false;
        }
        return true;
    }
}
