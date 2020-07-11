package queue;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class LinkedListQueue<Element> implements Queue<Element>{
    private  class Node{
        public Element element;
        public Node next;

        public Node(Element element, Node next){
            this.element = element;
            this.next = next;
        }

        public Node(Element element){
            this(element,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return element.toString();
        }
    }

    private Node head, tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
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
    public void enqueue(Element e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;

    }

    @Override
    public Element dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.element;
    }

    @Override
    public Element getFront() {
       if (isEmpty()) {
           throw new IllegalArgumentException("Queue is empty");
       }
       return head.element;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if (i%3==2){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
