package set;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public interface Set<Element> {
    void add(Element element);
    void remove(Element element);
    boolean contains(Element element);
    int getSize();
    boolean isEmpty();
}
