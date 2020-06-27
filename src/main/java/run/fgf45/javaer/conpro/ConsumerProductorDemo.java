package run.fgf45.javaer.conpro;

/**
 * @author fuguofeng
 * 生产两个线程
 *  第一个线程对一个数字加一
 *  第二个线程对一个数字减一
 *  反复五次
 */
public class ConsumerProductorDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    myCache.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "increment1").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    myCache.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "decrement1").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    myCache.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "increment2").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    myCache.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "decrement2").start();
    }

}

class MyCache{

    private volatile int number = 0;

    public synchronized void increment() throws InterruptedException {
        while(number != 0){
            this.wait();
        }

        number++;
        System.out.println(Thread.currentThread().getName() + "\tincrement\t" + this.number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while(number == 0){
            this.wait();
        }

        number--;
        System.out.println(Thread.currentThread().getName() + "\tdecrement\t" + this.number);
        this.notifyAll();
    }

}