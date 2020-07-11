package heap;

import array.Array;

/**
 * @author Hypnos Tsang
 * @date 2020/7/2
 */
public class MaxHeap<E extends Comparable<E>> {
    private final Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * @param index 索引
     * @return 父节点索引
     */
    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index){
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0){
            data.swap(index, parent(index));
            index = parent(index);
        }
    }


    private void  siftDown(int index){
        while (leftChild(index) < data.getSize()){
            int j = leftChild(index);
            if (j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0){
                j = rightChild(index);
            }
            if (data.get(index).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(index, j);
            index = j;
        }
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    /**
     *
     * @return 堆中最大元素
     */
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

}
