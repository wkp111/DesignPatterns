package com.wkp.design;

/**
 * 装饰模式
 * <p>
 *     装饰模式可以扩展一个类的功能，动态的为一个对象增加功能，还能动态的撤销。
 * </p>
 */
public class Decorator {
    /**
     * 装饰接口
     */
    interface Source{
        void method();
    }

    /**
     * 待装饰实现类
     */
    static class SourceImpl implements Source{

        @Override
        public void method() {
            System.out.println("Source something");
        }
    }

    /**
     * 装饰类
     */
    static class DecoratorSource implements Source{
        private Source mSource;

        public DecoratorSource(Source source) {
            mSource = source;
        }

        @Override
        public void method() {
            System.out.println("Decorator before source");
            mSource.method();
            System.out.println("Decorator after source");
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Source source = new DecoratorSource(new SourceImpl());
        source.method();
    }
}
