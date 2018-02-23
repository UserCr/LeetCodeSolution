/**
O(n^2)时间，O(1)空间算法是先把链表除random成员外拷贝一份，然后针对每个节点的random位找到对应位置，在拷贝串中找到相应节点赋值。
O(n)时间，O(n)空间的话思路同上，不过用map将每个原始节点和新节点关联起来，省去查找位置的时间。
还有一种比较巧妙的解法是将每个新生成的节点都放在对应原始节点的后边，那么每个新节点的random位也就是对应原始节点random位所指的后一个节点，
遍历两次拷贝完毕后再遍历一次分离原始节点和新节点并返回。实际上这个方法也是O(n)空间，只不过是用了原始节点的next位做了map关联，是in-place的。
**/

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode prevNode = null, curNode = head;
        while (curNode != null) {
            RandomListNode node = new RandomListNode(curNode.label);
            if (prevNode != null) {
                prevNode.next = node;
            }
            prevNode = node;
            map.put(curNode, node);
            curNode = curNode.next;
        }

        curNode = head;
        while (curNode != null) {
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }

        return map.get(head);
    }
}
