package queue;

import java.util.Random;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Main {
    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println(testQueue(new ArrayQueue<>(),opCount));
        System.out.println(testQueue(new LoopQueue<>(),opCount));
        System.out.println(testQueue(new LinkedListQueue<>(),opCount));
    }

    private static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            queue.dequeue();
        }
        return (System.nanoTime()-startTime) / 1000000000.0;
    }
}
