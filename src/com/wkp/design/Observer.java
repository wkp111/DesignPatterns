package com.wkp.design;

import javax.security.auth.Subject;
import java.util.Vector;

/**
 * 观察者模式
 * <p>
 *     观察者模式即监听模式，描述类与类之间的关系，主要是在目标类中注册监听器，当目标类的有效值实时改变时，通过监听器及时回调通知各个注册者。
 * </p>
 */
public class Observer {
    /**
     * 观察者接口
     */
    interface IObserver{
        void update(String data);
    }

    /**
     * 注册接口
     */
    interface Subject{
        /**
         * 增加观察者
         * @param observer
         */
        void add(IObserver observer);

        /**
         * 删除观察者
         * @param observer
         */
        void del(IObserver observer);

        /**
         * 通知更新
         */
        void notifyObservers();

        /**
         * 自身操作
         */
        void operation();
    }

    /**
     * 抽象注册接口
     */
    static abstract class AbstractSubject implements Subject {
        private Vector<IObserver> mObservers = new Vector<>();
        @Override
        public void add(IObserver observer) {
            mObservers.add(observer);
        }

        @Override
        public void del(IObserver observer) {
            mObservers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (IObserver observer : mObservers) {
                observer.update("Hello World");
            }
        }
    }

    /**
     * 注册实现
     */
    static class SubjectImpl extends AbstractSubject{

        @Override
        public void operation() {
            notifyObservers();
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        SubjectImpl subject = new SubjectImpl();
        subject.add(System.out::println);
        subject.add(System.out::println);
        Thread.sleep(1000);
        subject.operation();
    }
}
