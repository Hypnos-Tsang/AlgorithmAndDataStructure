package set;

import tree.BinarySearchTree;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class BinarySearchTreeSet<Element extends Comparable<Element>> implements Set<Element> {
    private final BinarySearchTree<Element> bst;

    public BinarySearchTreeSet(){
        bst = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(Element element) {
        bst.add(element);
    }

    @Override
    public boolean contains(Element element) {
        return bst.contains(element);
    }

    @Override
    public void remove(Element element) {
        bst.remove(element);
    }
}
