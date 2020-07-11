package heap;

import heap.MaxHeap;
import queue.Queue;

/**
 * 优先队列
 * @author Hypnos Tsang
 * @date 2020/7/3
 */
public class  PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private final MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }
}
