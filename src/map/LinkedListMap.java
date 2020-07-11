package map;

import set.FileOperation;
import java.util.ArrayList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }



    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }
        else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        else {
            node.value = newValue;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    public static void main(String[] args) {
        long time = System.nanoTime();
        String file = "E:\\data\\Pride_and_Prejudice.txt";
        System.out.println("Pride_and_Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(file, words)){
            System.out.println("Total words : " + words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words){
                if (map.contains(word)){
                    map.set(word, map.get(word) + 1);
                }
                else {
                    map.add(word, 1);
                }

            }
            System.out.println("Total different words : " + map.getSize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
            System.out.println((System.nanoTime() - time) / Math.pow(10,9));
        }
    }

}
