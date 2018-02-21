/**
分析题目可知，如果A和B相异部分一样长的话，A走一步B走一步，最后肯定会相遇或是都为null，A==B处就是交叉节点。
因此，问题就转化成怎么让A和B在相遇前走一样长的路。下边有两种方案。
Solution1：
先分别遍历一遍A和B，求出两个链的长度，在长链上先走几步直到剩余长度和短链相同，在用上述解法求解。
Solution2：
下边这个方法比较巧妙，A和B相异部分链接起来就一样长了，所以只要让两个下标分别从AB出发，分别走一遍A+B或B+A，就可以求解。需要走的步数和第一个方案一样。
示意图如下：
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
currentNodeA:a1->a2->c1->c2->c3->b1->b2->b3->c1->c2->c3
currentNodeB:b1->b2->b3->c1->c2->c3->a1->a2->c1->c2->c3
**/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;

        ListNode curNodeA = headA;
        ListNode curNodeB = headB;
        while (curNodeA != curNodeB) {
            curNodeA = curNodeA == null ? headB : curNodeA.next;
            curNodeB = curNodeB == null ? headA : curNodeB.next;
        }

        return curNodeA;
    }
}
