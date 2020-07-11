package stack;

import array.Array;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack.getCapacity());
        System.out.println(arrayStack);
    }
}
