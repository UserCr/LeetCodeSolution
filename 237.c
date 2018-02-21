/**
这个题目感觉有点问题，只给出要删除的节点却不给出前一个节点，导致根本没办法删除给定节点，只能将给定节点的后继节点内容复制过来，然后删除后继节点。
**/

void deleteNode(struct ListNode* node) {
    struct ListNode* next = node -> next;
    node -> val = next -> val;
    node -> next = next -> next;
    free(next);
}
