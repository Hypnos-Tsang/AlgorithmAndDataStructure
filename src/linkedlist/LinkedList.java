package linkedlist;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class LinkedList<Element> {
    private  class Node{
        public Element element;
        public Node next;

        public Node(Element element,Node next){
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

    private final Node dummyHead;
    private int size;
    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        // 获取链表中的元素个数
        return size;
    }

    public boolean isEmpty(){
        // 返回链表是否为空
        return size == 0;
    }

    public void add(int index,Element element){
        // 在链表的index（0-based）位置添加新的元素
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(element,prev.next);
        size++;
//        System.out.println("size = " + size);
    }

    public void addFirst(Element element){
        // 在链表前添加元素
//        Node node = new Node(element);
//        node.next = head;
//        head = node;

        add(0,element);
    }

    public void addLast(Element element){
        add(size,element);
    }

    public Element get(int index){
        // 遍历列表,返回index位置的元素
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    public Element getFirst(){
        return get(0);
    }

    public Element getLast(){
        return get(size-1);
    }

    public boolean set(int index,Element element){
        if (index < 0 || index >= size ){
//           throw  new IllegalArgumentException("Set Failed. Illegal index.");
           return false;
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.element = element;
        return true;
    }


    public boolean contains(Element element){
        // 查找链表中是否有元素element
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.element.equals(element)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public Element remove(int index){
        // 从列表中删除元素
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. index is illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.element;
    }

    public Element removeFirst(){
        return remove(0);
    }

    public Element removeLast(){
        return remove(size-1);
    }

    public void removeElement(Element element){
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.element.equals(element)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur.element).append("->");
            //cur or cur.element
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
