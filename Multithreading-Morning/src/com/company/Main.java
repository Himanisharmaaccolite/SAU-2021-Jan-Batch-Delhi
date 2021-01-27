package com.company;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String args[]) {

        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 5;
        Thread producer = new Producer(buffer, maxSize, "Producer");
        Thread consumer = new Consumer(buffer, maxSize, "Consuming");
        producer.start();
        consumer.start();
    }
}
class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    public Producer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue; this.maxSize = maxSize;
    }
    @Override public void run() {
        while (true) { synchronized (queue) {
            while (queue.size() == maxSize) {
                try {
                    System.out .println("Queue is full");
                    queue.wait();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            Random random = new Random();
            int i = random.nextInt();
            System.out.println("Adding value : " + i);
            queue.add(i); queue.notifyAll();
        }
        }
    }
}
class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    public Consumer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override public void run() {
        while (true) { synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty");
                try { queue.wait();
                }
                catch (Exception ex) { ex.printStackTrace();
                }
            }
            System.out.println("Removing value : " + queue.remove()); queue.notifyAll();
        }
        }
    }
}

