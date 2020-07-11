package array;

/**
 * @author Hypnos Tsang
 * @date 2020/6/29
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        int size = 20;
        for (int i = 0;i < size;i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr.toString());

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(-1);
        System.out.println(arr);
        System.out.println(arr.removeElement(3));
        System.out.println(arr);
    }

}
