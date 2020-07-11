package tree;

/**
 * @author Hypnos Tsang
 * @date 2020/7/4
 */
public interface Merge<E> {
    E merge(E a, E b);
}
