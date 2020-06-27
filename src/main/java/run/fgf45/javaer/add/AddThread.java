package run.fgf45.javaer.add;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fuguofeng
 * condition与lock应用
 */
public class AddThread {

    public static void main(String[] args) {
        MyAdd myAdd = new MyAdd();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myAdd.addPrint5();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myAdd.addPrint10();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myAdd.addPrint15();
            }
        }).start();

    }

}


class MyAdd{

    private volatile int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void addPrint5(){
        lock.lock();
        try {
            while(number != 0){
                condition.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("print5");
            }

            number = 1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addPrint10(){
        lock.lock();
        try {
            while(number != 1){
                condition.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("print10");
            }

            number = 2;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addPrint15(){
        lock.lock();
        try {
            while(number != 2){
                condition.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("print15");
            }

            number = 0;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}