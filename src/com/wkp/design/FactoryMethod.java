package com.wkp.design;

/**
 * 工厂方法模式
 * <p>
 *     工厂方法模式主要分为三种：
 *     1.普通工厂模式{@link FunctionCommonFactory}：建立一个工厂类，对实现了同一接口的类的实例创建，仅提供一个生产方法，根据不同标记位创建不同实例。
 *     2.多个工厂模式{@link FunctionMoreFactory}：建立一个工厂类，对实现了同一接口的类的实例创建，提供创建不同实例的多个方法（对1的改进）。
 *     3.静态工厂模式{@link FunctionStaticFactory}：建立一个工厂类，对实现了同一接口的类的实例创建，提供创建不同实例的多个静态方法（对2的改进）。
 * </p>
 */
public class FactoryMethod {
    /**
     * 共同功能接口
     */
    interface Function{
        void play();
    }

    /**
     * LOL游戏实现功能接口
     */
    static class Lol implements Function{

        @Override
        public void play() {
            System.out.println("Summoner! Please select your hero!");
        }
    }

    /**
     * 荒野行动游戏实现功能接口
     */
    static class KnivesOut implements Function{

        @Override
        public void play() {
            System.out.println("LYB");
        }
    }

    /**
     * 普通工厂类
     */
    static class FunctionCommonFactory{
        public static final int LOL = 0;
        public static final int KNO = 1;

        public Function produce(int flag) {
            switch (flag) {
                case LOL:
                    return new Lol();
                case KNO:
                    return new KnivesOut();
            }
            return null;
        }
    }

    /**
     * 多个工厂类
     */
    static class FunctionMoreFactory{
        public Function produceLol() {
            return new Lol();
        }

        public Function produceKno() {
            return new KnivesOut();
        }
    }

    /**
     * 静态工厂类
     */
    static class FunctionStaticFactory{
        public static Function produceLol() {
            return new Lol();
        }

        public static Function produceKno() {
            return new KnivesOut();
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        commonFactory();
        moreFactory();
        staticFactory();
    }

    /**
     * 静态工厂测试
     */
    private static void staticFactory() {
        Function lol = FunctionStaticFactory.produceLol();
        Function kno = FunctionStaticFactory.produceKno();
        lol.play();
        kno.play();
    }

    /**
     * 多个工厂测试
     */
    private static void moreFactory() {
        FunctionMoreFactory moreFactory = new FunctionMoreFactory();
        Function lol = moreFactory.produceLol();
        Function kno = moreFactory.produceKno();
        lol.play();
        kno.play();
    }

    /**
     * 普通工厂测试
     */
    private static void commonFactory() {
        FunctionCommonFactory commonFactory = new FunctionCommonFactory();
        Function lol = commonFactory.produce(FunctionCommonFactory.LOL);
        Function kno = commonFactory.produce(FunctionCommonFactory.KNO);
        lol.play();
        kno.play();
    }
}
