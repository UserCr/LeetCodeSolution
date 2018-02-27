/**
可以分治合并，也可以用堆维护一个k大小的集合，从堆里每拿走一个最小节点就把该节点的后继节点放入堆中。
**/

class Solution {
    class Heap {
        private int capacity;
        private int size;
        private ListNode[] data;

        public Heap(int capacity) {
            this.capacity = capacity;
            data = new ListNode[capacity + 1];
            size = 0;
        }

        private void swap(int i, int j) {
            data[0] = data[i];
            data[i] = data[j];
            data[j] = data[0];
        }

        public boolean insert(ListNode listNode) {
            if (size == capacity) return false;

            data[++size] = listNode;
            for (int i = size; i > 1; i /= 2) {
                if (data[i / 2].val > data[i].val) {
                    swap(i, i / 2);
                }
            }

            return true;
        }

        public ListNode remove() {
            if (0 == size) return null;

            ListNode result = data[1];
            data[1] = data[size--];
            for (int i = 1, childIndex; i * 2 <= size; i = childIndex) {
                childIndex = i * 2;

                if (childIndex + 1 <= size && data[childIndex + 1].val < data[childIndex].val) childIndex++;

                if (data[childIndex].val < data[i].val) {
                    swap(i, childIndex);
                } else {
                    break;
                }
            }
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        final int k = lists.length;
        Heap heap = new Heap(k);
        for (int i = 0; i < k; i++) {
            if (null != lists[i]) {
                heap.insert(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode result = null, resultEnd = null;
        while (!heap.isEmpty()) {
            if (null == result) {
                result = heap.remove();
                resultEnd = result;
            } else {
                resultEnd.next = heap.remove();
                resultEnd = resultEnd.next;
            }
            if (null != resultEnd.next) {
                heap.insert(resultEnd.next);
            }
        }

        return result;
    }
}
