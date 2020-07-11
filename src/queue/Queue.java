package queue;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public interface Queue<Element> {
    int getSize();
    boolean isEmpty();
    void enqueue(Element e);
    Element dequeue();
    Element getFront();
}
