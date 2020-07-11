package array;

/**
 * @author Hypnos Tsang
 * @date 2020/6/29
 */
public class Array<Element> {
    private Element[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int capacity){
        data = (Element[])new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public Array(Element[] arr){
        data = (Element[])new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        size = arr.length;
    }

    /**
     * 无参构造函数，默认capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * @return 获取数组的元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     * @return 返回数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @param index 索引
     * @param e 元素
     */
    public void add(int index,Element e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size");
        }

        if (size == data.length){
            resize(2 * size);
        }

        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = e;
        size++;
    }


    // 在元素最后一个面添加元素
    public void addLast(Element e){
//        if (size == data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size++] = e;
        add(size,e);
    }

    public void addFirst(Element e){
        add(0,e);
    }


    // 获取index位置的元素
    public Element get(int index){
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        return data[index];
    }

    public Element getLast() {
        return get(size - 1);
    }

    public Element getFirst(){
        return get(0);
    }

    //修改index位置的元素
    public void set(int index,Element e){
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(Element e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找元素的位置，没有就返回-1
    public int find(Element e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    public Element remove(int index){
        // 删除指定位置的元素,并返回这个元素
        if (index < 0 || index >=size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        Element ret = data[index];
        if (size - index + 1 >= 0) {
            System.arraycopy(data, index + 1, data, index + 1 - 1, size - index + 1);
        }
        size--;
        data[size] = null;
        // loitering objects != memory leak

        if (size == data.length/4 && data.length != 0){
            resize(data.length/2);
        }
        return ret;
    }

    // 删除第一个元素
    public Element removeFirst(){
        return remove(0);
    }

    // 删除最后一个元素
    public Element removeLast(){
        return remove(size-1);
    }

    //
    public boolean removeElement(Element e){
        int index = find(e);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public void swap(int i, int j){
        if (i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("index is illegal");
        }
        Element element = data[i];
        data[i] = data[j];
        data[j] = element;

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity){
        Element[] newData = (Element[])new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }

}
