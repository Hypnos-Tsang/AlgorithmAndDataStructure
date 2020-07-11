package stack;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public interface Stack<Element> {
    int getSize();
    boolean isEmpty();
    void push(Element e);
    Element pop();
    Element peek();

}
