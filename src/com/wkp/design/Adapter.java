package com.wkp.design;

/**
 * 适配器模式
 * <p>
 *     适配器模式主要分为三种：
 *     1.类的适配器模式{@link AdapterClass}：有一个{@link Source}类，拥有一个方法，待适配，目标接口是{@link Target}，通过{@link AdapterClass}类，
 *     将Source的功能扩展到Target里。
 *     2.对象的适配器模式{@link AdapterObject}：适配器类AdapterObject持有待适配类Source的引用，实现适配目标接口Target，调用待适配类Source的方法，
 *     可以解决兼容性问题（方法不一致性）。
 *     3.接口的适配器模式{@link AdapterInterface}：在实际开发中，接口{@link DownloadListener}中定义了太多的方法，我们在一些实现类中并不是都需要，
 *     则可以适配该接口。
 * </p>
 */
public class Adapter {
    /**
     * 待适配类
     */
    static class Source{
        public void method1() {
            System.out.println("Source method1");
        }
    }

    /**
     * 适配目标接口
     */
    interface Target{
        void method1();

        void method2();
    }

    /**
     * 适配器类（类的适配器模式）
     */
    static class AdapterClass extends Source implements Target{

        @Override
        public void method2() {
            System.out.println("Target method2");
        }
    }




    /**
     * 适配器类（对象的适配器模式）
     */
    static class AdapterObject implements Target{
        private Source mSource;

        public AdapterObject(Source source) {
            mSource = source;
        }

        @Override
        public void method1() {
            mSource.method1();
        }

        @Override
        public void method2() {
            System.out.println("Target method2");
        }
    }





    /**
     * 待适配接口（接口的适配器模式）
     */
    interface DownloadListener{
        void onPre();

        void onStart();

        void onProgress(int progress);

        void onSuccess();

        void onError();

        void onCompleted();
    }

    /**
     * 抽象类空实现接口（接口的适配器模式）
     */
    static abstract class SimpleDownloadListener implements DownloadListener{
        @Override
        public void onPre() {
        }

        @Override
        public void onStart() {
        }

        @Override
        public void onProgress(int progress) {
        }

        @Override
        public void onSuccess() {
        }

        @Override
        public void onError() {
        }

        @Override
        public void onCompleted() {
        }
    }

    /**
     * 适配接口，实现所需方法（接口的适配器模式）
     */
    static class AdapterInterface extends SimpleDownloadListener{
        @Override
        public void onProgress(int progress) {
            System.out.println("Progress: " + progress);
        }
    }
}
