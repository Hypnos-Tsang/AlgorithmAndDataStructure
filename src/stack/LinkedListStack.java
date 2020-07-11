package stack;

import linkedlist.LinkedList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class LinkedListStack<Element> implements Stack<Element> {
    private final LinkedList<Element> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(Element element){
        list.addFirst(element);
    }

    @Override
    public Element pop() {
        return list.removeFirst();
    }

    @Override
    public Element peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append("Stack: top ");
        str.append(list);
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }
}
