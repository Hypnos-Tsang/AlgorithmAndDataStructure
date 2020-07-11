package stack;

import array.Array;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class ArrayStack<Element> implements Stack<Element> {
    Array<Element> array;
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(Element e){
        array.addLast(e);
    }

    @Override
    public Element pop(){
        return array.removeLast();
    }

    @Override
    public Element peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:\n");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}

