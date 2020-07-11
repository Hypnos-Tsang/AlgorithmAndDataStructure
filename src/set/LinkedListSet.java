package set;

import linkedlist.LinkedList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class LinkedListSet<Element> implements Set<Element> {
    private LinkedList<Element> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(Element element) {
        if (!list.contains(element)) {
            list.addFirst(element);
        }
    }

    @Override
    public void remove(Element element) {
        list.removeElement(element);
    }

    @Override
    public boolean contains(Element element) {
        return list.contains(element);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
