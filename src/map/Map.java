package map;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public interface Map<K, V> {
    /**
     * 根据键删除
     * @param key 键
     * @return 删除的值
     */
    V remove(K key);
    V get(K key);
    int getSize();
    void add(K key,V value);
    void set(K key, V value);
    boolean contains(K key);
    boolean isEmpty();

}
