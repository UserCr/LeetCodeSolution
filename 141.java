/**
首先要理解题意。链表有环指的是下边这种情况，环形链表只是其中一个特例，所以不能用是否回到表头的方法判断。
1->2->3->4
   ^     | 
   |_____|
空间随意的情况下，只要用set或继承添加状态位的办法就行，非常简单。
O(1)空间的话，比较巧妙的办法是放两个速度不一样的指针去跑，有环的话快指针一定会追上慢指针，否则快指针一定会先到链表尾端结束循环。
还有种办法就是把next成员位当成visited来用，经过的节点next全部置成表头。
**/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (null == head) return false;

        ListNode walker = head, runner = head.next;
        while (runner != null && runner.next != null) {
            runner = runner.next;
            if (walker == runner) return true;
            runner = runner.next;
            if (walker == runner) return true;
            walker = walker.next;
        }
        return false;
    }
}
