package map;

import set.FileOperation;

import java.util.ArrayList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key ;
        public V value ;
        public Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTreeMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0 ) {
            return node;
        } else if (key.compareTo(node.key) < 0 ) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if (node == null){
            size ++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0 ){
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }
        else {
            node.value = value;
        }
        return node;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0 ){
            node.left = remove(node, key);
            return node;
        }
        else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }
        else { // key == node.key
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 左右子树都不为空
            Node successor = minNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node minNum(Node node){
        if (node.left == null){
            return node;
        }
        return minNum(node.left);
    }

    public static void main(String[] args) {
        long time = System.nanoTime();
        String file = "E:\\data\\Pride_and_Prejudice.txt";
        System.out.println("Pride_and_Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(file, words)){
            System.out.println("Total words : " + words.size());
            BinarySearchTreeMap<String, Integer> map = new BinarySearchTreeMap<>();
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
