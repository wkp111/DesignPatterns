package com.wkp.design;

/**
 * 中介者模式
 * <p>
 * 中介者模式是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，因为只要修改一个对象，其它关联的对象都得进行修改。
 * 如果使用中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行，这有点像spring容器的作用。
 * </p>
 */
public class MediatorDemo {
    /**
     * 中介者接口
     */
    interface Mediator {
        void createMediator();

        void workAll();
    }

    /**
     * 用户抽象类
     */
    static abstract class User {
        private Mediator mMediator;

        public Mediator getMediator() {
            return mMediator;
        }

        public User(Mediator mediator) {
            mMediator = mediator;
        }

        public abstract void work();
    }

    /**
     * 用户1
     */
    static class User1 extends User {

        public User1(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void work() {
            System.out.println("User1 do something");
        }
    }

    /**
     * 用户2
     */
    static class User2 extends User {

        public User2(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void work() {
            System.out.println("User2 do something");
        }
    }

    /**
     * 中介者实现类
     */
    static class MediatorImpl implements Mediator {
        private User1 mUser1;
        private User2 mUser2;

        public User1 getUser1() {
            return mUser1;
        }

        public User2 getUser2() {
            return mUser2;
        }

        @Override
        public void createMediator() {
            mUser1 = new User1(this);
            mUser2 = new User2(this);
        }

        @Override
        public void workAll() {
            mUser1.work();
            mUser2.work();
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Mediator mediator = new MediatorImpl();
        mediator.createMediator();
        mediator.workAll();
    }
}
