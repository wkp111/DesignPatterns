package com.wkp.design;

/**
 * 桥接模式
 * <p>
 *     桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，功能的调用基本不变。
 * </p>
 */
public class Bridge {
    /**
     * 桥接资源接口
     */
    interface Source{
        void method();
    }

    /**
     * 桥接资源的第一种实现
     */
    static class FirstSource implements Source{

        @Override
        public void method() {
            System.out.println("First");
        }
    }

    /**
     * 桥接资源的第二种实现
     */
    static class SecondSource implements Source{

        @Override
        public void method() {
            System.out.println("Second");
        }
    }

    /**
     * 桥接资源的桥
     */
    static abstract class BridgeSource{
        private Source mSource;

        protected Source getSource() {
            return mSource;
        }

        public void setSource(Source source) {
            mSource = source;
        }

        public abstract void method();
    }

    /**
     * 桥的管理类
     */
    static class BridgeManage extends BridgeSource{

        @Override
        public void method() {
            getSource().method();
        }
    }

    /**
     * 测试 客户启用功能
     * @param args
     */
    public static void main(String[] args) {
        BridgeManage manage = new BridgeManage();
        Source source1 = new FirstSource();
        manage.setSource(source1);
        manage.method();

        Source source2 = new SecondSource();
        manage.setSource(source2);
        manage.method();
    }
}
