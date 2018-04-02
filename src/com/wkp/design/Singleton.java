package com.wkp.design;

/**
 * 单例设计模式
 * <p>
 *     单例设计模式核心思想：私有构造方法，自己创建实例，对外提供获取实例方法。
 *     1.饿汉式{@link LazySingleton}：
 *     2.懒汉式{@link HungerSingleton}：
 * </p>
 */
public class Singleton {
    /**
     * 饿汉式
     */
    static class LazySingleton{
        //创建实例
        private static class Inner{
            private static LazySingleton sSingleton = new LazySingleton();
        }

        //私有构造
        private LazySingleton() {
        }

        //对外提供获取实例方法
        public static LazySingleton getInstance() {
            return Inner.sSingleton;
        }
    }

    /**
     * 懒汉式
     */
    static class HungerSingleton{
        private static HungerSingleton sSingleton = null;

        private HungerSingleton() {
        }

        public static HungerSingleton getInstance() {
            if (sSingleton == null) {
                synchronized (HungerSingleton.class){
                    if (sSingleton == null) {
                        sSingleton = new HungerSingleton();
                    }
                }
            }
            return sSingleton;
        }
    }
}
