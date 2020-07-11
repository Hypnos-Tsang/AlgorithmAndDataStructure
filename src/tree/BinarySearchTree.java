package tree;

import queue.ArrayQueue;
import stack.ArrayStack;
import stack.LinkedListStack;


/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class BinarySearchTree<Element extends Comparable<Element>>  {
    /**
     * 二分搜索树
     */
    private class Node {
        public Element element;
        public Node left, right;
        public Node(Element element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Element element){
//        if (root == null){
//            root = new Node(element);
//            size ++ ;
//        }
//        else {
//            add(root, element);
//        }
        root = add(root, element);
    }
    private Node add(Node node, Element element){
//            if (element.equals(node.element)) return;
//            else if (element.compareTo(node.element) < 0 && node.left == null){
//                node.left = new Node(element);
//                size ++;
//                return;
//            }
//            else if (element.compareTo(node.element) > 0 && node.right == null){
//                node.right = new Node(element);
//                size ++;
//                return;
//            }
//            if (element.compareTo(node.element) < 0 ){
//                add(node.left, element);
//            }
//            else {
//                add(node.right, element);
//            }

            if (node == null){
                size ++;
                return new Node(element);
            }
            if (element.compareTo(node.element) < 0 ){
                node.left = add(node.left, element);
            }else if (element.compareTo(node.element) > 0){
                node.right = add(node.right, element);
            }
            return node;
    }

    public boolean contains(Element element){
        return contains(root, element);
    }

    private boolean contains(Node node, Element element){
        if (node == null){
            return false;
        }
        if (element.compareTo(node.element) == 0){
            return true;
        }
        else if (element.compareTo(node.element) < 0){
            return contains(node.left, element);
        }
        else {
            return contains(node.right, element);
        }
    }

    public void preOrderNR(){
        ArrayStack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.element);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void preOrderNR2(){
        LinkedListStack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.element);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    public void levelOrder(){
        ArrayQueue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.element);
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }

    public Element minNum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node ret = minNum(root);
        return ret.element;
    }

    private Node minNum(Node node){
        if (node.left == null) {
            return node;
        }
        return minNum(node.left);
    }

    public Element maxNum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node ret = maxNum(root);
        return ret.element;
    }

    private Node maxNum(Node node){
        if (node.right == null) {
            return node;
        }
        return maxNum(node.right);
    }


    /**
     * 删除最小值并返回值
     * @return 最小值
     */
    public Element removeMin(){
        Element ret = minNum();
        root = removeMin(root);
        return ret;
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

    /**
     * 删除最大值并返回值
     * @return 最大值
     */
    public Element removeMax(){
        Element ret = maxNum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(Element element){
        root = remove(root, element);
    }

    private Node remove(Node node, Element element){
        if (node == null) {
            return null;
        }
        if (element.compareTo(node.element) < 0 ){
            node.left = remove(node, element);
            return node;
        }
        else if (element.compareTo(node.element) > 0){
            node.right = remove(node.right, element);
            return node;
        }
        else { // element == node.element
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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null){
            res.append(generaDepthString(depth)).append("null\n");
            return;
        }
        res.append(generaDepthString(depth)).append(node.element).append("\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generaDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
